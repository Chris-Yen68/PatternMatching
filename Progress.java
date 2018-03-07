/**
 * Created by jeanlee on 2017/11/2.
 */




public class Progress {
    private static Progress _sharedInstance = new Progress();

    private static Progress sharedInstance(){
        return _sharedInstance;
    }

    private int total;
    private int now;
    private int progress;

    private void _setup(int total){
        this.total = total;
        now = 0;
        progress = -1;
        _update(0);

    }

    private void _update(int value){
        double rate = value * 100.0 / total;
        setProgress((int)rate);
    }

    private void _count(){
        now++;
        update(now);
    }

    private void _finish(){
        System.out.print("\r");
    }

    public void setProgress(int progress) {
        if (this.progress != progress) {
            System.out.print("\rProgressing... " + progress + "%");
        }
        this.progress = progress;
    }

    public static void setup(int total){
        _sharedInstance._setup(total);
    }

    public static void update(int value){
        _sharedInstance._update(value);
    }

    public static void count(){
        _sharedInstance._count();
    }

    public static void finish(){
        _sharedInstance._finish();
    }

}

