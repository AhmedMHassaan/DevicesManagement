/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.gson.reflect.TypeToken;
import data.local.db.connection.LocalDatabaseConnection;
import data.local.local_db_repos.BrandsLocalRepository;
import data.local.queries_operations.BrandsLocalDbQueries;
import data.local.queries_operations.ResultSetParser;
import data.pojo.Brand;
import data.pojo.Department;
import data.pojo.Model;
import data.pojo.responses.ServerResponse;
import data.remote.HttpRequests;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.Constants;
import utils.Base64Utils;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class BrandsRepository extends BrandsLocalRepository implements BrandsRepositoryImpl {

    private static BrandsRepository instance;

    public synchronized static BrandsRepository getInstance() {

        synchronized (BrandsRepository.class) {
            if (instance == null) {
                synchronized (BrandsRepository.class) {
                    instance = new BrandsRepository();
                }
            }
        }

        return instance;
    }

    private BrandsRepository() {
    }

    @Override
    public ArrayList<Brand> getAllBrands() {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Brands/getAllBrands.php";
            Type type = new TypeToken<ServerResponse<ArrayList<Brand>>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ArrayList<Brand>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<Brand> getOnlyBrandNames() {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Brands/getAllBrands.php?brandsNamesOnly=true";
            Type type = new TypeToken<ServerResponse<ArrayList<Brand>>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ArrayList<Brand>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }

    }

    @Override
    public boolean addNewBrand(String brand) {
        try {
            String params = "brand_name=" + Base64Utils.encode(brand);  // encode because arabic
            String url = Constants.API_LINK + "Brands/addNewBrand.php";
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBrand(int brandId) {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Brands/deleteBrand.php"
                    + "?brand_id=" + brandId;
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateBrand(int brandId, String brandName) {
        try {

            String params = "brand_name=" + Base64Utils.encode(brandName)
                    + "&brand_id=" + brandId;
            String url = Constants.API_LINK + "Brands/updateBrand.php";
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Brand> getAllBrandsByTypeId(int typeId) {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Brands/getAllBrands.php?type_id=" + typeId;
            Type type = new TypeToken<ServerResponse<ArrayList<Brand>>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ArrayList<Brand>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<Brand> getAllLocalBrands() {
        return getAllLocalBrandsByTypeId(-1);
    }

    @Override
    public ArrayList<Brand> getAllLocalBrandsByTypeId(int typeId) {
        BrandsLocalDbQueries brandsLocalDbQueries = null;
        Type type = new TypeToken<ArrayList<Brand>>() {
        }.getType();
        try {

            brandsLocalDbQueries = new BrandsLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement brandsPrepareStatement = brandsLocalDbQueries.getAllBrandsPreparedStatment(typeId);
            ResultSet brandsResultSet = brandsPrepareStatement.executeQuery();

            ArrayList<Brand> brands = new ResultSetParser<ArrayList<Brand>>().parseResultSet(brandsResultSet, type);
            brandsLocalDbQueries.destroy();
            brandsLocalDbQueries = null;

            return brands;
        } catch (Exception e) {

            brandsLocalDbQueries.destroy();
            System.out.println("Ex=> "+e);
            Logger.getLogger(BrandsRepository.class.getName()).log(Level.SEVERE, null, e);
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<Brand> getOnlyLocalBrandNames() {
        ArrayList<Brand> allBrands = getAllLocalBrands();
        ArrayList<Brand> responseBrands = new ArrayList<>();

        Set<Integer> ids = new HashSet<>();
        allBrands.forEach((brand) -> {
            boolean isBrandIdAddedToArray = ids.add(brand.getBrandId());
            if (isBrandIdAddedToArray) {
                responseBrands.add(brand);
            }

        });
        return responseBrands;
    }

    @Override
    public boolean addNewLocalBrand(String brand) {
        return addNewLocalBrand(brand, true);
    }

    public boolean addNewLocalBrand(String brand, boolean showAlertMessages) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new BrandsLocalDbQueries(connection).getInsertNewBrandPreparedStatment(brand);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                MessageBox.showMessage(" تم إضافة " + brand + " بنجاح");
            }
            connection.close();

            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "اسم الشركة (" + brand + ") مضاف من قبل";
            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    public String addNewLocalBrand(Connection connection, String brand) {
        try {

            PreparedStatement ps = new BrandsLocalDbQueries(connection).getInsertNewBrandPreparedStatment(brand);
            boolean isInserted = !ps.execute();

            return null;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم الشركة (" + brand + ") مضاف من قبل";
//            }
//            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return error;
        }
    }

    @Override
    public boolean deleteLocalBrand(int brandId) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new BrandsLocalDbQueries(connection).getDeleteBrandPreparedStatment(brandId);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                MessageBox.showMessage(" تم حذف الشركة  بنجاح");
            }
            connection.close();
            System.gc();
            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();

            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    @Override
    public boolean updateLocalBrand(int brandId, String brandName) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new BrandsLocalDbQueries(connection).getUpdateBrandPreparedStatment(brandId, brandName);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                MessageBox.showMessage(" تم تعديل " + brandName + " بنجاح");
            }
            connection.close();
            System.gc();
            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "اسم الشركة (" + brandName + ") مضاف من قبل";
            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    @Override
    public Brand getBrandFromItsName(String brandName) {
        try {
            return getBrandFromItsName(LocalDatabaseConnection.getConnection(), brandName);
        } catch (Exception e) {
            return null;
        }
    }

    public Brand getBrandFromItsName(Connection connection, String brandName) {
        BrandsLocalDbQueries brandsLocalDbQueries = null;

        try {

            brandsLocalDbQueries = new BrandsLocalDbQueries(connection);
            PreparedStatement brandsPrepareStatement = brandsLocalDbQueries.getBrandFromItsNamePreparedStatment(brandName);
            ResultSet brandResultSet = brandsPrepareStatement.executeQuery();

//            Brand brand = new ResultSetParser<Brand>().parseResultSet(brandResultSet, type);
            Brand brand = null;
            while (brandResultSet.next()) {
                brand = new Brand(brandResultSet.getInt(1), brandResultSet.getString(2));

            }

//            brandsLocalDbQueries.destroy();
//            brandsLocalDbQueries = null;
            return brand;
        } catch (Exception e) {

//            brandsLocalDbQueries.destroy();
            System.out.println("Error from getBrandFromItsName()->  "+e.getMessage());
            Logger.getLogger(BrandsRepository.class.getName()).log(Level.SEVERE, null, e);
//            MessageBox.showErrorMessage(e.getMessage());
            return null;
        }
    }

    ServerResponse<Brand> getBrandIdOrInsert(Connection connection, String brandName) throws Exception {
        Brand brand = getBrandFromItsName(connection, brandName);
        if (brand != null) {
            return new ServerResponse<>(1, "", brand);
        } else {
            String error = addNewLocalBrand(connection, brandName);
//            connection.commit();
            if (error == null) {
                return getBrandIdOrInsert(connection, brandName);
            } else {
//                throw new Exception("لم يتم إيجاد الشركة أو إضافته");
                return new ServerResponse<>(0, error, null);
            }
        }
    }

}
