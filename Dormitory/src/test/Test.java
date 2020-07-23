package test;

import java.util.Scanner;

import biz.Biz;


/**
 * 测试类
 * @author Administrator
 *
 */
public class Test {
	static Biz biz=new Biz();
	public static void main(String[] args) {
		show();
	}
	
	public static void show(){
		System.out.println("欢迎使用宿舍管理查询系统");
		System.out.println("1.查询所有学生信息");
		System.out.println("2.按学号排序(升序)");
		System.out.println("3.按房号排序(升序)");
		System.out.println("4.按姓名查询 ");
		System.out.println("5.按学号查询 ");
		System.out.println("6.按房号查询 ");
		System.out.println("7.添加学生信息 ");
		System.out.println("8.修改学生信息");
		System.out.println("9.删除学生信息");
		System.out.println("0.退出系统");
		while(true){
			System.out.println("请输入您的选项");
			Scanner sc=new Scanner(System.in);
			String choice=sc.nextLine();
			switch(choice){
				case "1":
					System.out.println("所有学生信息");
					biz.findAll();
					break;
				case "2":
					System.out.println("学号排序");
					biz.sortBySid();
					break;
				case "3":
					System.out.println("房号排序");
					biz.sortByRid();
					break;
				case "4":
					System.out.println("请输入您要查询的姓名");
					String name=sc.nextLine();
					biz.findByName(name);
					break;
				case "5":
					System.out.println("请输入您要查询的学号");
					String sid=sc.nextLine();
					biz.findBySid(sid);
					break;
				case "6":
					System.out.println("请输入您要查询的房号");
					String rid=sc.nextLine();
					biz.findByRid(rid);
					break;
				case "7":
					System.out.println("已有学生信息:");
					biz.sortBySid();
					System.out.println("添加学生信息(注:学号不可重复;格式:姓名-学号-房号):");
					String info=sc.nextLine();
					biz.add(info);
					break;
				case "8":
					System.out.println("请输入您要修改的学生学号");
					String id=sc.nextLine();
					biz.findBySid(id);
					System.out.println("请修改该学生信息(格式:姓名-房号)");
					String content=sc.nextLine();
					biz.update(id,content);
					break;
				case "9":
					biz.sortBySid();
					System.out.println("请输入您要删除学生信息的学号");
					String stuid=sc.nextLine();
					biz.delete(stuid);
					break;
				case "0":
					System.out.println("您已退出系统");
					System.exit(0);
				default:
					System.out.println("您输入的选项有误!请重新输入");
			}
		}
	}
}