package nyc.c4q.ac21.signboard;

/**
 * Created by ashiquechowdhury on 9/5/16.
 */
public class PictureTest {
    private String pic;

    public PictureTest(String pic) {
        this.pic = pic;
    }

    public String[] pictureArray(){
        StringBuilder SB = replaceNewLines(pic);
        int rowCharacterNumber = lengthOfRoW(pic);
        int heightNumber = (SB.length()/rowCharacterNumber);
        String[] sbArray = new String[heightNumber];
        System.out.println(SB.substring(0,41).length());
        for(int i=0; i< heightNumber; i++){
            sbArray[i] = SB.substring(0,41);
            SB.delete(0,41);
        }
        return sbArray;
    }

    public int lengthOfRoW(String pokemon){
        int counter = 0;
        for(int i=0; i<pokemon.length();i++){
            counter++;
            if(pokemon.substring(i,i+1).equals("\n")){
                {
                    break;
                }
            }
        }
        return counter;
    }


    public StringBuilder replaceNewLines(String pokemon){
        StringBuilder sb = new StringBuilder(pokemon);
        for(int i=0; i<pokemon.length();i++){
            if(pokemon.substring(i,i+1).equals("\n")){
                {
                    sb.replace(i, i+1, " ");
                }
            }
        }
        return sb;
    }
}
