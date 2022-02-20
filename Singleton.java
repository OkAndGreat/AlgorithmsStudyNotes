public class Singleton<T> {
    private volatile static T t;

    public T getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    private Singleton(){

    }
}
