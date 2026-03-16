public class Main {
    public static void main ( String[] args ) {
        UI ui = new UI();
        while (true){
            if(ui.functions()){
                break;
            }
        }
    }
}