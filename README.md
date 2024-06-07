The java.sql package contains interfaces and classes of JDBC API.
 1.import
 2.load driver using class.forname();
 3.connection con =Drivermanager.getConnection(url,name, pass);
 4.preparedStatement ps = con.preparedStatemnt(query);
