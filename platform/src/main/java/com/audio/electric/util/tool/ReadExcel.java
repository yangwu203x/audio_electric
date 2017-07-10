package com.audio.electric.util.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	private static final Log log = LogFactory.getLog(ReadExcel.class);

	/**
	 * 判断后缀分批入
	 */
	public static List<Map<Integer,Object>> parseSuccexx(InputStream str,String fileName ,int nums){
		
		String [] pfix= fileName.split("\\.");
		String suffix = pfix[pfix.length -1];
		
		if( suffix!=null&&!suffix.equals("")&&suffix.equals("xls")){
			// jxl方法可读取.xls格式
			return jlxExcel(str,nums);
		}else if(suffix .equals("xlsx")){
			// poi方法可读取Excel2007即.xlsx格式
			return poiExcel(str ,nums);
		}
		return null;
	}
	
	/**
	 * 读取 xls JXL
	 * @param str
	 * @param nums 解析行数
	 */
	private static List<Map<Integer,Object>> jlxExcel(InputStream str , int nums){
			//===============jlx方法=================
		List<Map<Integer,Object>> list = new ArrayList<>();
			try{
			// 构造Workbook（工作薄）对象
			Workbook rwb=Workbook.getWorkbook(str);
			Sheet rs=rwb.getSheet(0);//获取第一张工作表
			int rsRows=rs.getRows();//获取Sheet表中所包含的总行数
			int rsCols=rs.getColumns();//获取Sheet表中所包含的总列数
			log.info("========行========"+rsRows+"=====列========"+rsCols);
			if (nums == -1)
				nums = rsRows;
			for(int i=1;i<nums;i++){//读取行
				log.info("========执行第========"+i+"行");
				Map<Integer,Object> map = new HashMap<>();
				for(int j=0;j<rsCols;j++){
					Cell coo=rs.getCell(j, i);//单元格定位列，再定位行
					String strc=coo.getContents();//读取内容
					map.put(j,strc);
				}
				list.add(map);
			}
			rwb.close();  
			}catch (FileNotFoundException e) {   
				 e.printStackTrace();   
			} catch (BiffException e) {   
			 e.printStackTrace();   
			} catch (IOException e) {   
			 e.printStackTrace();   
			}   
				
			//==========读取excel文件内容=结束=====================
			return list;
	}
	
	/**
	 * POI读取   xlsx
	 * @param str
	 * @param nums 解析行数
	 */
	private static List<Map<Integer,Object>> poiExcel(InputStream str,int nums){
		List<Map<Integer,Object>> list = new ArrayList<>();
		try{
			XSSFWorkbook xwb = new XSSFWorkbook(str);  //利用poi读取excel文件流
			XSSFSheet st = xwb.getSheetAt(0);  //读取sheet的第一个工作表
			int rows=st.getLastRowNum();//总行数
			int cols;//总列数
			log.info("========行========"+rows);
			if (nums == -1)
				nums = rows;
			for(int i=0;i<nums;i++){
				XSSFRow row=st.getRow(i);//读取某一行数据
				if(row!=null){
					Map<Integer,Object> map = new HashMap<>();
					//获取行中所有列数据
					cols=row.getLastCellNum();
					log.info("========行========"+rows+"=====列========"+cols);
					for(int j=0;j<cols;j++){
						XSSFCell cell=row.getCell(j);
						if(cell==null){
							map.put(j,"");
						}else{
						//判断单元格的数据类型
						switch (cell.getCellType()) {
							case XSSFCell.CELL_TYPE_NUMERIC: // 数字
								map.put(j,cell.toString());
								break;
							case XSSFCell.CELL_TYPE_STRING: // 字符串
								map.put(j,cell.getStringCellValue());
								break;
							case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
								map.put(j,cell.getBooleanCellValue());
								break;
							case XSSFCell.CELL_TYPE_FORMULA: // 公式
								System.out.print(cell.getCellFormula() + "   ");
								map.put(j,cell.getCellFormula());
								break;
							case XSSFCell.CELL_TYPE_BLANK: // 空值
								map.put(j,"");
								break;
							case XSSFCell.CELL_TYPE_ERROR: // 故障
								map.put(j,"");
								break;
							default:
								map.put(j,"");
								break;
							}
						}
					}
					list.add(map);
				}
			}
		}catch(IOException e){
			e.printStackTrace();   
		}
		return list;
	}

	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "enter.xlsx";
		String realPath = "C:\\Users\\Administrator\\Desktop\\"+fileName;
		InputStream str = null;
		int nums = 100;
		try {
			str = new FileInputStream(realPath);
			List<Map<Integer,Object>> list = parseSuccexx(str, fileName ,nums);
			System.out.println(list.size());
			System.out.println(list.get(0).toString());
			System.out.println(list.get(1).get(1));
			System.out.println(list.get(2).toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
