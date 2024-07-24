package Aula1;
public class Padrao_3 {
    
    public static void main(String[] args) {
        Database padrão3Database = new Padrão3Database("MyDatabase");

        padrão3Database.connect();

        padrão3Database.connect();
    }
    
}

//----------------------------------------------------
    interface Database {
        void connect();
    }

//----------------------------------------------------

    class RealDatabase implements Database {
        private String dbName;
    
        public RealDatabase(String dbName) {
            this.dbName = dbName;
            initializeConnection();
        }
    
        private void initializeConnection() {
            System.out.println("Initializing connection to the database: " + dbName);
        }
    
        @Override
        public void connect() {
            System.out.println("Connecting to the database: " + dbName);
        }
    }
  
//----------------------------------------------------

    class Padrão3Database implements Database {
        private RealDatabase realDatabase;
        private String dbName;
    
        public Padrão3Database(String dbName) {
            this.dbName = dbName;
        }
    
        @Override
        public void connect() {
            if (realDatabase == null) {
                realDatabase = new RealDatabase(dbName);
            }
            realDatabase.connect();
        }
    }
    
    
    
    

