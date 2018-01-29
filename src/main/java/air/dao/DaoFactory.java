package air.dao;

public class DaoFactory {
    public static IDao getWriter(String type) {
        IDao writer = null;
        if ("file".equalsIgnoreCase(type)) {
            writer = DaoFileImpl.getDao();
        } else if ("db".equalsIgnoreCase(type)) {
            writer = new DaoDBImpl();
        }
        return writer;
    }
}
