BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "departments" (
	"dep_id"	integer,
	"department"	char(50) NOT NULL UNIQUE,
	PRIMARY KEY("dep_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "devices_brands" (
	"brand_id"	integer NOT NULL,
	"brand"	char(50) NOT NULL UNIQUE,
	PRIMARY KEY("brand_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "devices_types" (
	"type_id"	integer NOT NULL,
	"type"	char(50) NOT NULL UNIQUE,
	PRIMARY KEY("type_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "devices_models" (
	"model_id"	integer NOT NULL,
	"brand_id"	integer NOT NULL,
	"type_id"	integer NOT NULL,
	"model"	char(30) NOT NULL,
	CONSTRAINT "uk_brand_id_and_model_name" UNIQUE("brand_id","model"),
	FOREIGN KEY("brand_id") REFERENCES "devices_brands"("brand_id"),
	FOREIGN KEY("type_id") REFERENCES "devices_types"("type_id"),
	PRIMARY KEY("model_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "devices_transactions" (
	"trans_id"	int(11) NOT NULL,
	"device_id"	int(11) NOT NULL,
	"current_department_id"	int(11) NOT NULL,
	"distination_department_id"	int(11) NOT NULL,
	"receiver_name"	varchar(100) NOT NULL,
	"sender_name"	varchar(100) NOT NULL,
	"trans_timestamp"	timestamp NOT NULL DEFAULT current_timestamp,
	"transaction_reason"	text NOT NULL
);
CREATE TABLE IF NOT EXISTS "devices" (
	"id"	INTEGER NOT NULL,
	"serial_number"	TEXT NOT NULL UNIQUE,
	"current_department_id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"model_id"	INTEGER NOT NULL,
	"adding_timestamp"	timestamp NOT NULL DEFAULT current_timestamp,
	FOREIGN KEY("current_department_id") REFERENCES "departments"("dep_id"),
	FOREIGN KEY("model_id") REFERENCES "devices_models"("model_id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "departments" ("dep_id","department") VALUES (276,'النظم');
INSERT INTO "departments" ("dep_id","department") VALUES (277,'الطبية');
INSERT INTO "departments" ("dep_id","department") VALUES (278,'التعليم');
INSERT INTO "departments" ("dep_id","department") VALUES (279,'لواء الجنود');
INSERT INTO "departments" ("dep_id","department") VALUES (281,'الأفراد');
INSERT INTO "departments" ("dep_id","department") VALUES (282,'المعنوي');
INSERT INTO "departments" ("dep_id","department") VALUES (283,'لواء الطلبة');
INSERT INTO "departments" ("dep_id","department") VALUES (284,'المهمات');
INSERT INTO "departments" ("dep_id","department") VALUES (285,'المسجل');
INSERT INTO "departments" ("dep_id","department") VALUES (286,'الخزنة');
INSERT INTO "departments" ("dep_id","department") VALUES (287,'المطبعة');
INSERT INTO "departments" ("dep_id","department") VALUES (288,'ميس الطلبة');
INSERT INTO "departments" ("dep_id","department") VALUES (289,'شئون الضباط');
INSERT INTO "departments" ("dep_id","department") VALUES (290,'القضاء');
INSERT INTO "departments" ("dep_id","department") VALUES (291,'نائب المدير');
INSERT INTO "departments" ("dep_id","department") VALUES (292,'الابتكارات');
INSERT INTO "departments" ("dep_id","department") VALUES (293,'اتجاه التربية');
INSERT INTO "departments" ("dep_id","department") VALUES (294,'التخطيط');
INSERT INTO "departments" ("dep_id","department") VALUES (295,'الامن');
INSERT INTO "departments" ("dep_id","department") VALUES (296,'مكتب المدير');
INSERT INTO "departments" ("dep_id","department") VALUES (297,'التراسل');
INSERT INTO "departments" ("dep_id","department") VALUES (298,'الماليات ');
INSERT INTO "departments" ("dep_id","department") VALUES (299,'المتابعة');
INSERT INTO "departments" ("dep_id","department") VALUES (300,'مساعد المدير');
INSERT INTO "departments" ("dep_id","department") VALUES (301,'ورشة النظم');
INSERT INTO "departments" ("dep_id","department") VALUES (302,'الحملة ');
INSERT INTO "departments" ("dep_id","department") VALUES (303,'تكهين');
INSERT INTO "departments" ("dep_id","department") VALUES (304,'البيطري');
INSERT INTO "devices_brands" ("brand_id","brand") VALUES (75,'DELL');
INSERT INTO "devices_brands" ("brand_id","brand") VALUES (76,'HP');
INSERT INTO "devices_brands" ("brand_id","brand") VALUES (77,'EPSON');
INSERT INTO "devices_brands" ("brand_id","brand") VALUES (78,'HITACHI');
INSERT INTO "devices_brands" ("brand_id","brand") VALUES (79,'Fujitsu');
INSERT INTO "devices_brands" ("brand_id","brand") VALUES (80,'Rack');
INSERT INTO "devices_types" ("type_id","type") VALUES (46,'كمبيوتر');
INSERT INTO "devices_types" ("type_id","type") VALUES (47,'سكانر');
INSERT INTO "devices_types" ("type_id","type") VALUES (48,'طابعة');
INSERT INTO "devices_types" ("type_id","type") VALUES (49,'لابتوب');
INSERT INTO "devices_types" ("type_id","type") VALUES (50,'بروجكتور');
INSERT INTO "devices_types" ("type_id","type") VALUES (51,'Rack');
INSERT INTO "devices_types" ("type_id","type") VALUES (53,'Switch');
INSERT INTO "devices_types" ("type_id","type") VALUES (54,'Rak');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (133,75,46,'dell');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (134,76,47,'A4 scanjet');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (135,77,47,'A3');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (137,76,49,'PROBOOK 4530S');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (138,76,46,'quad core 500 B');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (139,78,50,'بروجكتور');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (142,76,48,'ألوان');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (143,76,46,'Core 2');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (144,76,46,'Core i5');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (145,79,46,'Siemens');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (146,79,51,'single core');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (147,79,46,'Esprimo ');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (148,76,48,'2055');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (149,76,48,'402');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (150,76,48,'400');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (152,76,48,'3015');
INSERT INTO "devices_models" ("model_id","brand_id","type_id","model") VALUES (154,80,54,'راك');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1705,'717ZMV1',276,'معمل 1',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1706,'8LDCQ03',276,'معمل 1',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1707,'9P41NV1',277,'الصيدلية',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1708,'9W6ZMV1',276,'معمل 1',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1709,'B733NV1',278,'المكتبة',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1710,'BWL8R1J',276,'معمل 4',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1711,'CHT8R1J',276,'معمل 4',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1712,'CN2AFAD0CR',297,'التراسل',134,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1713,'CN43B3M0S3',276,'المخزن',135,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1714,'CNCJ871296',276,'المخزن',148,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1715,'CNCJN53641',276,'المخزن',148,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1716,'CNCJN77346',276,'المخزن',148,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1717,'CNCJN80422',293,'الاسكواش',148,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1718,'CNU2070KMW',296,'مكتب المدير',137,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1719,'CZC0404SLN',279,'مكتب الأفراد',138,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1720,'DLH1Q03',276,'رئيس فرع النظم',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1721,'DX41NV1',277,'قائد الطبية',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1722,'DZ8R1J8',276,'معمل 4',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1723,'F3KE03508',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1724,'F3KE03509',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1725,'F3KE03510',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1726,'F3KE03513',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1727,'F3KE03514',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1728,'F3KE03515',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1729,'F3KE03516',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1730,'F3KE03517',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1731,'F3KE03518',291,'مكتب النائب',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1732,'F3KE03520',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1733,'F3KE03521',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1734,'F3KE03522',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1735,'F3KE03523',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1736,'F3KE03526',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1737,'F3KE03527',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1738,'F3KE03528',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1739,'F3KE03532',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1740,'F3KE03533',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1741,'F3KE03535',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1742,'F3KE03537',282,'قاعة',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1743,'F3KE03538',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1744,'F3KE03540',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1745,'F3KE03541',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1746,'F3KE03542',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1747,'F3KE03544',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1748,'F3KE03546',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1749,'F3KE03547',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1750,'F3KE03548',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1751,'F3KE03549',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1752,'F3KE03550',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1753,'F3KE03551',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1754,'F3KE03552',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1755,'F3KE03553',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1756,'F3KE03554',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1757,'F3KE03555',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1758,'F3KE03556',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1760,'F3KE03557',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1761,'F3KE03558',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1762,'F3KE03559',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1763,'F3KE03560',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1764,'F3KE03561',276,'معمل 3',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1765,'F3KE03594',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1766,'F3KE03595',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1767,'F3KE03621',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1768,'F3KE03696',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1769,'F3KE03697',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1770,'F3KE03698',276,'الفصل',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1771,'F3KE03699',276,'معمل 2',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1772,'F3KE03700',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1773,'F3KE03702',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1774,'F3KE03703',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1775,'F3KE03704',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1776,'F3KE03705',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1777,'F3KE03708',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1778,'F3KE03709',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1779,'F3KE03710',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1780,'F3KE03711',276,'معمل 4',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1781,'F3KE03712',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1782,'F3KE03713',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1783,'F3KE03714',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1784,'F3KE03715',276,'معمل 1',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1785,'F3KE03719',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1786,'F3KE03723',282,'قاعة',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1787,'F3KE03795',292,'معمل الابتكارات',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1788,'F3KE03811',292,'معمل الابتكارات',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1789,'F3KE03824',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1790,'F3KE03828',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1791,'F3KE03945',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1792,'F3KE03946',276,'المخزن',139,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1793,'FTRXM03',276,'رئيس فرع النظم',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1794,'GHT8R1G',276,'معمل 3',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1795,'GHT8R1J',276,'معمل 2',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1796,'GXL8R1J',276,'معمل 4',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1797,'GZ8R1J1',276,'معمل 4',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1798,'H1L8R1J',276,'معمل 4',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1799,'PHCPB47454',289,'مكتب ضباط الصف',149,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1800,'PHCPH50181',298,'مكتب الماليات',149,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1801,'PHKBD42197',294,'مكتب ض صف',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1802,'PHKBD42318',291,'مكتب ص إيهاب',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1803,'PVZZ001725',301,'طابعة Officejet ألوان',142,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1804,'SCZC0112LZS',281,'مكتب صف الضباط',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1805,'SCZC0112M01',282,'ستوديو',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1806,'SCZC0112M04',278,'كبير المعلمين',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1807,'SCZC0112M0C',276,'معمل 1',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1808,'SCZC0112M0Z',276,'معمل 2',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1809,'SCZC0112M15',276,'معمل 1',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1810,'SCZC0112M3C',283,'ش إدارية',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1811,'SCZC0112M3P',278,'مناهج',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1812,'SCZC0112M43',276,'معمل 1',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1813,'SCZC0112M4Q',284,'المهمات',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1814,'SCZC0112M4Z',285,'مكتب ضباط الصف',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1815,'SCZC0112M54',278,'بحوث',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1816,'SCZC0112M57',285,'مكتب ضباط الصف',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1817,'SCZC0112M5B',278,'امتحانات',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1818,'SCZC0112M5F',283,'قائد',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1819,'SCZC0112M5V',281,'مكتب ضباط الصف',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1820,'SCZC0112M5W',286,'الخزنة',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1821,'SCZC0112M5Z',276,'معمل 1',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1822,'SCZC0112M66',287,'المطبعة',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1823,'SCZC011M5D',288,'ميس الطلبة',143,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1824,'TRF338099H',289,'مكتب رئيس الفرع',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1825,'TRF338099J',290,'القضاء',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1826,'TRF338099K',291,'مكتب ص ايهاب',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1827,'TRF338099L',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1828,'TRF338099M',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1829,'TRF338099N',279,'مكتب التدريب',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1830,'TRF338099P',278,'وسائل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1831,'TRF338099S',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1832,'TRF338099T',293,'صالة الاسكواش',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1833,'TRF338099V',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1834,'TRF338099W',292,'المقلد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1835,'TRF338099Y',281,'قائد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1836,'TRF338099Z',278,'مكتبة عسكرية',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1837,'TRF33809B2',287,'بانر',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1838,'TRF33809B3',294,'مكتب رئيس الفرع',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1839,'TRF33809B4',295,'مكتب قائد الأمن - البوابة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1840,'TRF33809B5',296,'سكرتارية المدير',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1841,'TRF33809B6',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1842,'TRF33809B7',292,'المقلد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1843,'TRF33809B8',282,'القاعة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1844,'TRF33809B9',292,'التحويلة - المنصة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1845,'TRF33809BB',296,'مكتب المدير',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1846,'TRF33809BC',278,'قاعة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1847,'TRF33809BD',297,'التراسل – جهاز الشبكة العسكرية',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1848,'TRF33809BH',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1849,'TRF33809BK',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1850,'TRF33809BM',292,'المقلد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1851,'TRF33809BP',298,'الماليات',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1852,'TRF33809BQ',276,'المقدم - الطلبة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1853,'TRF33809BT',282,'مجلس الكلية',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1854,'TRF33809BV',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1855,'TRF33809BW',299,'المتابعة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1856,'TRF33809BX',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1857,'TRF33809BY',292,'المقلد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1858,'TRF33809BZ',297,'التراسل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1859,'TRF33809C0',278,'سيف',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1860,'TRF33809C2',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1861,'TRF33809C3',283,'شئون',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1862,'TRF33809C4',294,'مكتب ضباط الصف',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1863,'TRF33809C7',276,'المقدم - طلبة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1864,'TRF33809C8',283,'مكتب الإنضباط',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1865,'TRF33809C9',300,'مساعد المدير',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1866,'TRF33809CC',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1867,'TRF33809CD',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1868,'TRF33809CH',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1869,'TRF33809CJ',301,'ورشة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1870,'TRF33809CK',287,'بانر',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1871,'TRF33809CN',296,'سكرتارية المدير',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1872,'TRF33809CP',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1873,'TRF33809CQ',283,'قائد مكتب الإنضباط',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1874,'TRF33809CS',295,'مكتب الصف',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1875,'TRF33809CT',278,'المكتبة العسكرية',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1876,'TRF33809CW',291,'مكتب النائب',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1877,'TRF33809CX',294,'مكتب ضباط الصف',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1878,'TRF33809D1',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1879,'TRF33809D2',292,'المعمل',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1880,'TRF33809D3',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1881,'TRF33809D4',289,'مكتب الصف',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1882,'TRF33809D5',295,'قائد الأمن - المنصة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1883,'TRF33809D6',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1884,'TRF33809D7',285,'مكتب الصف',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1885,'TRF33809D8',285,'عقيد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1886,'TRF33809D9',293,'الصالة',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1887,'TRF33809DB',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1888,'TRF33809DC',296,'مكتب المدير',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1889,'TRF33809DD',276,'مكتب نظم المعلومات',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1890,'TRF33809DF',292,'المقلد',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1891,'TRF33809DG',302,'التسليح',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1892,'TRF33809DH',276,'معمل 1',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1893,'TRF33809DM',292,'نقيب وسام كيما',144,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1894,'VNC3T07750',279,'مكتب التدريب',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1895,'VNC5112604',283,'شئون طلبة',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1896,'VNH5806289',295,'الامن',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1897,'VNH5806326',277,'الطبية',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1898,'VNH5806400',290,'القضاء',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1899,'VNH5808336',296,'مكتب المدير',150,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1900,'YBBG050762',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1901,'YBBG050821',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1902,'YBBG151523',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1903,'YKAM071651',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1904,'YKAM071655',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1905,'YKAM071657',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1906,'YKAM071689',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1907,'YKAM071725',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1908,'YKAM146320',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1909,'YKAM146387',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1910,'YKAM146390',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1911,'YKAM146399',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1912,'YKAM146402',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1913,'YKAM146408',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1914,'YKAM146431',303,'تكهين',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1915,'YKAM146448',303,'تكهين',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1916,'YKAM147015',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1917,'YKAM147023',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1918,'YKAM147844',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1919,'YKAM147850',278,'مدرج 25 أبريل',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1920,'YKAM147852',304,'البيطري',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1921,'YKAM147860',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1922,'YKAM147861',303,'تكهين',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1923,'YKAM147868',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1924,'YKAM147881',278,'مدرج العاشر',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1925,'YKAM147883',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1926,'YKAM147885',278,'العقيد الليثي',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1927,'YKAM147886',278,'المكتبة الثقافية',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1928,'YKAM147890',303,'تكهين',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1929,'YKAM147892',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1930,'YKAM147906',303,'تكهين',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1931,'YKAM147923',278,'الامتحانات',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1932,'YKAM147965',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1933,'YKAM147969',278,'المكتبة الثقافية',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1934,'YKAM147996',278,'مدرج 6 أكتوبر',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1935,'YKAM148004',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1936,'YKAM148073',278,'مدرج 23 يوليو',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1937,'YKAM148081',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1938,'YKAM148083',276,'معمل 2',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1939,'YL1B013761',298,'أحمد فهمى',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1940,'YL1F010952',301,'القاهرة',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1941,'YLFK015755',276,'سيرفر منظومة الإمتحانات',146,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1942,'YLFK015782',276,'سيرفر منظومة الإمتحانات',146,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1943,'YLJC006904',276,'معمل 1',147,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1944,'YUGA010224',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1945,'YUGA010326',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1946,'YUGA010379',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1947,'YUGA010387',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1948,'YUGA010429',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1949,'YUGA010475',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1950,'YUGA010491',276,'المخزن',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1951,'YUGA010529',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1952,'YUGA010536',276,'المخزن',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1953,'YUGA010545',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1954,'YUGA010549',276,'المخزن',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1955,'YUGA010584',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1956,'YUGA010606',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1957,'YUGA010623',276,'معمل 4',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1958,'YUGA010683',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1959,'YUGA010706',276,'معمل 3',145,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (1960,'ZN6ZMV1',276,'معمل 1',133,'2022-12-06 08:38:45');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (2217,'F3KE03556(مكرر)',276,'المخزن',139,'2022-12-07 08:19:51');
INSERT INTO "devices" ("id","serial_number","current_department_id","name","model_id","adding_timestamp") VALUES (2220,'aaaa',276,'aaa',133,'2022-12-11 15:24:21');
COMMIT;
