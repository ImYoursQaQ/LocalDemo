import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");
        Main main = new Main();

        ArrayList<String> line = new ArrayList<>();
        line = main.generateSQL();
        StringBuffer sb = new StringBuffer("INSERT INTO DM_XZQH_TABLE (CID,FL1,FL2,FL3,FL4,FL5,PINDEX,SAMPLENAME,CXFLDM) VALUES");
        sb.append("\n");
        int i = 0;
        for (String s : line) {
            String [] arr = s.split("\\s+");
            String cid = arr[0];
            String type = arr[1];
            String samplename = arr[2];

            String sql = "('"+cid+"','"+cid.substring(0,2)+"','"+cid.substring(2,4)+"','"+cid.substring(4,6)+"','"+cid.substring(6,9)+"','"+cid.substring(9,12)+"','"+i+"','"+samplename+"','"+type+"'),";
            sb.append(sql).append("\n");

            i++;

        }
        System.out.println(sb.substring(0,sb.length()-2).toString());
        
        
       /* String path = "E:\\460400";
        File file = new File(path);
        File[] tempList = file.listFiles();
        String[] fpath = new String[tempList.length];
        for (int i = 0; i < tempList.length; i++) {
            fpath[i] = tempList[i].getPath();
        }

       // mergeFiles(fpath,"E:\\hainanout.txt");
    */
    }
    /**
     *
     * ?????txt??????
     *
     * ***/

    public static boolean mergeFiles(String[] fpaths, String resultPath) {
        if (fpaths == null || fpaths.length < 1 || resultPath.equals("")) {
            return false;
        }
        if (fpaths.length == 1) {
            return new File(fpaths[0]).renameTo(new File(resultPath));
        }

        File[] files = new File[fpaths.length];
        for (int i = 0; i < fpaths.length; i ++) {
            files[i] = new File(fpaths[i]);
            if (fpaths[i].equals("") || !files[i].exists() || !files[i].isFile()) {
                return false;
            }
        }

        File resultFile = new File(resultPath);

        try {
            int bufSize = 1024;
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
            byte[] buffer = new byte[bufSize];

            for (int i = 0; i < fpaths.length; i ++) {
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(files[i]));
                int readcount;
                while ((readcount = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, readcount);
                }
                inputStream.close();
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        for (int i = 0; i < fpaths.length; i ++) {
            files[i].delete();
        }

        return true;
    }


    public ArrayList<String> generateSQL(){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String name = "E:\\hainanout.txt";
            FileReader fr = new FileReader(name);
            InputStreamReader ir = new InputStreamReader(new FileInputStream(name),"GB2312");
            BufferedReader bf = new BufferedReader(ir);


            String str;
            // ???ж???????
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return arrayList; 

    }

}
