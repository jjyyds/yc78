package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件处理类
 * @author Administrator
 *
 */
public class Util {
	static File file =new File("src/data.txt");
	/**
	 * 读取文件信息并存储到集合中
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public List<Map<String,String>> read() throws Exception{
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		try {
			String str = null;
			List<Map<String, String>> list= new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			while ((str = br.readLine()) != null) {
				map = new HashMap<String, String>();
				String s[] = str.trim().split("-");
				map.put("姓名", s[0]);
				map.put("学号", s[1]);
				map.put("房号", s[2]);
				list.add(map);
			}
			return list;
		}finally{
			br.close();
			reader.close();
		}
	}
	
	/**
	 * 添加学生信息
	 * @param info
	 * @throws Exception
	 */
	public void add(String info) throws Exception{
		FileWriter writer=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(writer);
		bw.newLine();
		bw.write(info);
		bw.flush();
		bw.close();
		writer.close();
	}
	
	/**
	 * 修改学生信息
	 * @param list
	 * @throws IOException 
	 */
	public void update(List<Map<String,String>> list) throws IOException{
		FileWriter writer=new FileWriter(file,false);
		BufferedWriter bw=new BufferedWriter(writer);
		int i;
		for(i=0;i<list.size();i++){
			bw.write(list.get(i).get("姓名")+"-"+list.get(i).get("学号")+"-"+list.get(i).get("房号"));
			if(i<list.size()-1){
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		writer.close();
	}
}
