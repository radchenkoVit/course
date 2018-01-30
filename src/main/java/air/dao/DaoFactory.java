package air.dao;

public class DaoFactory {
    public static IDao getInstance(DaoType type) {
        IDao writer = null;
        if (type == DaoType.File) {
            writer = DaoFileImpl.getDao();
        } else if (type == DaoType.DB) {
            writer = DaoDBImpl.getDao();
        }
        return writer;
    }
}
