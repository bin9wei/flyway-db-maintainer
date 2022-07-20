# flyway-db-maintainer
Java application using flyway to do database schema change with version control, support release and rollback.

## how to run locally
Run `App` from your IDE.
* To release, run without vm options
* To rollback, run with vm options `-Drollback=true`

## What DB is supported
For test purpose it use H2 embeded database, you can replace with any database supported by flyway. 

You need to
* Add related jdbc dependency in `pom.xml`
* Change db details in `App` as you need
````
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "my_user";
    static final String PASS = "mypassword123!";
````