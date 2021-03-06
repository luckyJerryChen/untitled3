import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2016/6/5.原始数据处理成带空值得的可放excel显示的数据
 */
public class PreProcess2 {
    public static void main(String args[]){

        try{
            List<Integer> list=new LinkedList<Integer>();



                String fname="C:\\Users\\lenovo\\Desktop\\ali\\data\\data218\\pred.txt";
                File f=new File(fname);
                InputStreamReader is = new InputStreamReader (new FileInputStream(f),"UTF-8");
                BufferedReader reader=new BufferedReader(is);
                String line=reader.readLine();
                int m=1;
                while(line!=null){
                    if(m%243==1){
                        for(int i=0;i<183;++i){
                            list.add(0);
                            m++;
                        }
                    }
                    list.add(Integer.parseInt(line.split(",")[1]));
                    line=reader.readLine();
                    m++;
                }
                reader.close();


            OutputStreamWriter iw=new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\ali\\data\\data218\\pred2.csv")),"UTF-8");
            BufferedWriter writer=new BufferedWriter(iw);
            Iterator<Integer> it=list.iterator();
            while(it.hasNext()){
                int b=it.next();
                writer.write(Integer.toString(b));
                writer.newLine();
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
