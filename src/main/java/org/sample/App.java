package org.sample;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "my_user";
    static final String PASS = "mypassword123!";

    static final boolean IS_ROLLBACK = "true".equalsIgnoreCase(System.getProperty("rollback", "false"));
    static final String MIGRATION_LOCATION = IS_ROLLBACK ? "migration/rollback" : "migration/release";

    public static void main(String[] args) {
        LOG.info("rollback={}, flyway migration location={}", IS_ROLLBACK, MIGRATION_LOCATION);
        Flyway flyway = Flyway.configure()
                .locations(MIGRATION_LOCATION)
                .dataSource(DB_URL, USER, PASS)
                .validateOnMigrate(false)
                .baselineOnMigrate(true)
                .sqlMigrationPrefix("0")
                .load();
        flyway.migrate();
    }
}
