package biz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Util;

/**
 * 业务处理类
 * @author Administrator
 *
 */
public class Biz {
	Util u=new Util();
	/**
	 * 查看所有学生信息
	 */
	public void findAll(){
		try {
			List<Map<String, String>> list = u.read();
			show(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据学号排序
	 */
	public void sortBySid(){
		try {
			List<Map<String,String>> list=u.read();
			for(int i=0,length=list.size();i<length-1;i++){
				for(int j=0;j<length-1-i;j++){
					if(Integer.parseInt(list.get(j).get("学号"))>Integer.parseInt(list.get(j+1).get("学号"))){
						Collections.swap(list, j, j+1);
					}
				}
			}
			show(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据房号排序
	 */
	public void sortByRid(){
		try {
			List<Map<String,String>> list=u.read();
			for(int i=0,length=list.size();i<length-1;i++){
				for(int j=0;j<length-1-i;j++){
					if(Integer.parseInt(list.get(j).get("房号"))>Integer.parseInt(list.get(j+1).get("房号"))){
						Collections.swap(list, j, j+1);
					}
				}
			}
			show(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据姓名查询
	 */
	public void findByName(String name){
		try {
			List<Map<String,String>> list=u.read();
			List<Integer> index=new ArrayList<Integer>();
			for(int i=0,length=list.size();i<length;i++){
				if(name.equals(list.get(i).get("姓名"))){
					index.add(i);
					continue;
				}
			}
			if(index.size()==0){
				System.out.println("暂无此学生信息");
				return;
			}
			for(int i=0,length=index.size();i<length;i++){
				System.out.println(list.get(index.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据学号查询
	 */
	public void findBySid(String sid){
		try {
			List<Map<String,String>> list=u.read();
			List<Integer> index=new ArrayList<Integer>();
			for(int i=0,length=list.size();i<length;i++){
				if(sid.equals(list.get(i).get("学号"))){
					index.add(i);
					continue;
				}
			}
			if(index.size()==0){
				System.out.println("暂无此学生信息");
				return;
			}
			for(int i=0,length=index.size();i<length;i++){
				System.out.println(list.get(index.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据房号查询
	 */
	public void findByRid(String rid){
		try {
			List<Map<String,String>> list=u.read();
			List<Integer> index=new ArrayList<Integer>();
			for(int i=0,length=list.size();i<length;i++){
				if(rid.equals(list.get(i).get("房号"))){
					index.add(i);
					continue;
				}
			}
			if(index.size()==0){
				System.out.println("暂无此学生信息");
				return;
			}
			for(int i=0,length=index.size();i<length;i++){
				System.out.println(list.get(index.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加学生信息
	 * @param info
	 */
	public void add(String info){
		String str[]=info.split("-");
		try {
			List<Map<String, String>> list = u.read();
			for(Map m:list){
				if(str[1].equals(m.get("学号"))){
					System.out.println("学号不可重复");
					return;
				}
			}
		} catch (Exception e1) {
			System.out.println("格式有误");
			return;
		}
		if(str.length!=3){
			System.out.println("格式有误");
			return;
		}else{
			try {
				u.add(info);
				System.out.println("添加成功");
			} catch (Exception e) {
				System.out.println("格式有误");
				return;
			}
		}
	}
	
	/**
	 * 根据学号修改学生信息
	 * @param id
	 */
	public void update(String id,String content){
		try {
			List<Map<String, String>> list = u.read();
			int i;
			for(i=0;i<list.size();i++){
				if(id.equals(list.get(i).get("学号"))){
					break;
				}
			}
			String s[]=content.split("-");
			if(s.length!=2){
				System.out.println("格式有误");
				return;
			}
			Map<String,String> map=new HashMap<String, String>();
			map.put("姓名", s[0]);
			map.put("学号", id);
			map.put("房号", s[1]);
			list.set(i, map);
			u.update(list);
			System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除学生信息
	 * @param id
	 */
	public void delete(String id){
		try {
			List<Map<String, String>> list = u.read();
			List<Integer> index=new ArrayList<Integer>();
			for(int i=0,length=list.size();i<length;i++){
				if(id.equals(list.get(i).get("学号"))){
					index.add(i);
					continue;
				}
			}
			if(index.size()==0){
				System.out.println("暂无此学生信息");
				return;
			}
			int i;
			for(i=0;i<list.size();i++){
				if(id.equals(list.get(i).get("学号"))){
					break;
				}
			}
			list.remove(i);
			u.update(list);
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 遍历集合展示数据
	 * @param list
	 */
	public void show(List<Map<String,String>> list){
		for(Map m:list){
			System.out.println(m.toString());
		}
	}
}
