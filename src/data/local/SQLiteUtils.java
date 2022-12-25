/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local;

import java.sql.*;

/**
 *
 * @author pc
 */
public class SQLiteUtils {

    private static void createTable(Connection connection, String sql) throws Exception {
        Statement statment = connection.createStatement();
        boolean executed = statment.execute(sql);
//        System.out.println("Executed ? => " + executed);
    }

    public static void createDBTables(Connection connectionInstance) throws Exception {

        enableForeignKeysCheck(connectionInstance);

        createDepartmentDBTable(connectionInstance);
//        System.out.println("Deps Created ! ");
        createBrandsTable(connectionInstance);
//        System.out.println("Brands Created ! ");
        createDevicesTypesTable(connectionInstance);
//        System.out.println("Dev Types Created ! ");
        createDevicesModelsTable(connectionInstance);
//        System.out.println("Dev Models Created ! ");
        createDevicesTable(connectionInstance);
//        System.out.println("Devices Created ! ");
        createDevicesTransactionsTable(connectionInstance);
//        System.out.println("Dev Transaction Created ! ");

        System.out.println("Tables Created Successfully !");
    }

    private static void createDepartmentDBTable(Connection connection) throws Exception {

//        CREATE TABLE `departments` (  `dep_id` integer PRIMARY KEY    AUTOINCREMENT ,  `department`  char(50) UNIQUE NOT NULL)
        String sql = " CREATE TABLE if not EXISTS `departments` ("
                + "  `dep_id` integer PRIMARY KEY    AUTOINCREMENT ,"
                + "  `department`  char(50) UNIQUE NOT NULL"
                + ");";
        createTable(connection, sql);
    }

    private static void createBrandsTable(Connection connection) throws Exception {
//        CREATE TABLE `devices_brands` (  `brand_id` integer  PRIMARY KEY    AUTOINCREMENT NOT NULL,  `brand` char(50) UNIQUE NOT NULL)

        String sql = "CREATE TABLE if not EXISTS  `devices_brands` ("
                + "  `brand_id` integer  PRIMARY KEY    AUTOINCREMENT NOT NULL,"
                + "  `brand` char(50) UNIQUE NOT NULL"
                + ");";

        createTable(connection, sql);
    }

    private static void createDevicesTypesTable(Connection connection) throws Exception {
        String sql = "CREATE TABLE  if not EXISTS `devices_types` ( "
                + "  `type_id` integer  PRIMARY KEY    AUTOINCREMENT NOT NULL , "
                + "  `type` char(50) UNIQUE NOT NULL "
                + "); ";
        createTable(connection, sql);
    }

    private static void createDevicesModelsTable(Connection connection) throws Exception {
//CREATE TABLE `devices_models` (   `model_id` integer  PRIMARY KEY AUTOINCREMENT NOT NULL ,   `brand_id` integer NOT NULL,   `type_id` integer NOT NULL ,   `model` char(30) NOT NULL,  FOREIGN KEY(brand_id) REFERENCES  devices_brands(brand_id),  FOREIGN KEY(type_id) REFERENCES devices_types(type_id),  Constraint uk_brand_id_and_model_name UNIQUE  (brand_id, model)  )
        String sql = "CREATE TABLE if not EXISTS `devices_models` ( "
                + "  `model_id` integer  PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + "  `brand_id` integer NOT NULL, "
                + "  `type_id` integer NOT NULL , "
                + "  `model` char(30) NOT NULL, "
                + " FOREIGN KEY(brand_id) REFERENCES  devices_brands(brand_id), "
                + " FOREIGN KEY(type_id) REFERENCES devices_types(type_id), "
                + " Constraint uk_brand_id_and_model_name UNIQUE  (brand_id, model)  "
                + ")  ";
//        System.out.println(sql);

        createTable(connection, sql);
    }

    private static void createDevicesTable(Connection connection) throws Exception {
        //        CREATE TABLE "devices" (
        //	"id"	INTEGER NOT NULL,
        //	"serial_number"	TEXT NOT NULL UNIQUE,
        //	"current_department_id"	INTEGER NOT NULL,
        //	"name"	TEXT NOT NULL,
        //	"model_id"	INTEGER NOT NULL,
        //	"adding_timestamp"	timestamp NOT NULL DEFAULT current_timestamp,
        //	PRIMARY KEY("id" AUTOINCREMENT),
        //	FOREIGN KEY("model_id") REFERENCES "devices_models"("model_id"),
        //	FOREIGN KEY("current_department_id") REFERENCES "departments"("dep_id")
//        )

        String sql = "   CREATE TABLE if not EXISTS `devices` ("
                + "	`id`	INTEGER NOT NULL,"
                + "	`serial_number`	TEXT NOT NULL UNIQUE,"
                + "	`current_department_id`	INTEGER NOT NULL,"
                + "	`name`	TEXT NOT NULL ,"
                + "	`model_id`	INTEGER NOT NULL,"
                + "	`adding_timestamp`	timestamp NOT NULL DEFAULT current_timestamp,"
                + "	PRIMARY KEY(`id` AUTOINCREMENT),"
                + "     FOREIGN KEY(current_department_id) REFERENCES  departments(dep_id), "
                + "     FOREIGN KEY(model_id) REFERENCES devices_models(model_id)"
                + " );";

//        String sql = "CREATE TABLE if not EXISTS `devices` ( "
//                + "  `id` int(11) NOT NULL, "
//                + "  `serial_number` varchar(20) NOT NULL, "
//                + "  `current_department_id` int(11) NOT NULL, "
//                + "  `name` varchar(50) NOT NULL, "
//                + "  `model_id` int(11) NOT NULL, "
//                + "  `adding_timestamp` timestamp NOT NULL DEFAULT current_timestamp "
//                + ") ;"
//                + "ALTER TABLE `devices` "
//                + "  ADD PRIMARY KEY (`id`), "
//                + "  ADD UNIQUE KEY `serial_number` (`serial_number`), "
//                + "  ADD KEY `department_id` (`current_department_id`), "
//                + "  ADD KEY `model_id` (`model_id`);";
        createTable(connection, sql);
    }

    private static void createDevicesTransactionsTable(Connection connection) throws Exception {
	

        
        String sql = "CREATE TABLE if not EXISTS `devices_transactions` ( "
                + "  `trans_id` INTEGER NOT NULL, "
                + "  `device_id` INTEGER NOT NULL, "
                + "  `current_department_id` INTEGER NOT NULL, "
                + "  `distination_department_id` INTEGER NOT NULL, "
                + "  `receiver_name` TEXT NOT NULL, "
                + "  `sender_name` TEXT NOT NULL, "
                + "  `trans_timestamp` timestamp NOT NULL DEFAULT current_timestamp, "
                + "  `transaction_reason` TEXT NOT NULL, "
                + "PRIMARY KEY(`trans_id` AUTOINCREMENT), "
                + "FOREIGN KEY(`distination_department_id`) REFERENCES  departments(dep_id),"
                + " FOREIGN KEY(`device_id`) REFERENCES devices(id),"
                + " FOREIGN KEY(`current_department_id`) REFERENCES departments(dep_id)"
                + ");  ";

        createTable(connection, sql);
    }

    private static void enableForeignKeysCheck(Connection c) throws Exception {
        boolean execute = c.createStatement().execute("PRAGMA foreign_keys = ON");
//        System.out.println("Execute "+execute);
    }

}
