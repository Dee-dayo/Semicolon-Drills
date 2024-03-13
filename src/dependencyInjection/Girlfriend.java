package dependencyInjection;

public class Girlfriend {
    private Boyfriend myBoyfriend;

    public Girlfriend(Boyfriend myBoyfriend){
        this.myBoyfriend = myBoyfriend;
    }

    public void setBoyfriend(Boyfriend myBoyfriend){
        this.myBoyfriend = myBoyfriend;
    }

    public void spend(){
        myBoyfriend.spend();
    }

}
