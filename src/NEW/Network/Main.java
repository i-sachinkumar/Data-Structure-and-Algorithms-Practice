package NEW.Network;

public class Main {
    public static void main(String[] args) throws Exception {
        Networking n = new Networking();
        String js = n.getText("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s");
        System.out.println(js);

    }
}
