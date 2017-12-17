public class URLcreate {
    String city;
    String appid;
    String url;
    URLcreate(String city, String appid,String url){
        this.city = city;
        this.appid = appid;
        this.url = url;
    }
    public String make_url(){
        return this.url+"?q="+this.city+"&APPID="+this.appid;
    }
}
