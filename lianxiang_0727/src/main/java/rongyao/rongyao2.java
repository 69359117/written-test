package rongyao;

import java.util.*;
import java.util.concurrent.locks.Condition;

/*

I MusicA Pop
I MusicB Pop
I MusicC Blue
I MusicD Blue
I MusicE UnkownStyle
I MusicF Pop
P MusicA
P MusicB
B MusicC
P MusicF
B MusicD
B MusicE

*/




public class rongyao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        ArrayList<String> strings = new ArrayList<>();
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            if (s!=null && s.equals("")) {
                break;
            }
            strings.add(s);
        }

        Solution(strings);
    }


    public static void Solution(ArrayList<String> strings) {

        String lastPlay = null;
        String lastBroke = null;

        // 歌曲，分数
        HashMap<String, Integer> points = new HashMap<>();
//        TreeMap<String, Integer> points = new TreeMap<>();

        // 歌曲，种类
        HashMap<String, String> songKind = new HashMap<>();
        // 种类，歌曲集合
        HashMap<String, ArrayList<String>> kindSongs = new HashMap<>();

//        TreeMap<String, ArrayList<String>> kindSongs = new TreeMap<>();

        for (String string : strings) {
            String[] s = string.split(" ");
            if (s.length == 3) {            // 导入歌曲
                songKind.put(s[1], s[2]);
                points.put(s[1], 0);
                if (!kindSongs.containsKey(s[2])) {
                    ArrayList<String> tem = new ArrayList<>();
                    tem.add(s[1]);
                    kindSongs.put(s[2], tem);
                } else {
                    kindSongs.get(s[2]).add(s[1]);
                }
            } else {                     // 播放/中断 歌曲
                String nowKind = songKind.get(s[1]);
                if (s[0].equals("P")) {   // 当前操作为播放
                    Integer integer = points.get(s[1]);
                    points.put(s[1], integer + 3);
                    if (!nowKind.equals("UnkownStyle") && lastPlay != null && lastPlay.equals(nowKind)) {
                        ArrayList<String> songs = kindSongs.get(nowKind);
                        for (String song : songs) {
                            if (song.equals(s[1])) {
                                continue;
                            }
                            Integer i = points.get(song);
                            points.put(song, i + 1);
                        }
                    }
                    lastPlay = nowKind;
                } else {                 // 当前操作为中断
                    Integer integer = points.get(s[1]);
                    points.put(s[1], integer - 2);

                    if (!nowKind.equals("UnkownStyle") && lastBroke != null && lastBroke.equals(nowKind)) {
                        ArrayList<String> songs = kindSongs.get(nowKind);
                        for (String song : songs) {
                            if (song.equals(s[1])) {
                                continue;
                            }
                            Integer i = points.get(song);
                            points.put(song, i - 1);
                        }
                    }
                    lastBroke = nowKind;
                }
            }
        }

//        for (Map.Entry<String, Integer> stringIntegerEntry : points.entrySet()) {
//            System.out.println(stringIntegerEntry.getKey().toString());
//            System.out.println(stringIntegerEntry.getValue());
//        }

//        new TreeMap<String,Integer>()
//        points

        List<Map.Entry> list = new ArrayList<>(points.entrySet());

        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator <Map.Entry>() {
            //升序排序
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return o1.getValue()==o2.getValue() ? ((String)o1.getKey()).compareTo((String)o2.getKey()) : (Integer)o2.getValue()-(Integer)o1.getValue() ;
//                return (Integer)o1.getValue() - (Integer)o2.getValue();
            }
        });

        for(Map.Entry mapping:list){
            System.out.println(mapping.getKey()+" "+songKind.get(mapping.getKey()));
        }
    }

}

