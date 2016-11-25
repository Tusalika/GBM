package com.yang.ExcelAnalysis;

import com.yang.vo.Word;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import com.yang.DAO.StoragewordDAO;
import jxl.Sheet;
import jxl.Workbook;


/**
 * Created by Adminitster on 2016/11/14.
 */
public class readWordData {
    public static List<Word> readXlsResourse(String path){
        Workbook readwb=null;
        List<Word> wordlist=new LinkedList<Word>();
        try {
            //构建WrokBook对象，只读Workbook对象
            //直接从本地文件创建Workbook
            InputStream instream=new FileInputStream(path);
            readwb=Workbook.getWorkbook(instream);

            //sheet的下标是从0开始的
            //获取第一张Sheet表
            Sheet readsheet=readwb.getSheet(0);

            //获取Sheet表中所包含的总列数
            int rsColums=readsheet.getColumns();

            int rsRows=readsheet.getRows();
            System.out.println(rsRows);
            for(int i=0;i<rsRows;i++){
                Word word=new Word();
                System.out.println(readsheet.getCell(0,i).getContents());
                word.setId(readsheet.getCell(0,i).getContents());
                word.setWord(readsheet.getCell(1,i).getContents());
                word.setA(readsheet.getCell(2,i).getContents());
                word.setB(readsheet.getCell(3,i).getContents());
                word.setC(readsheet.getCell(4,i).getContents());
                word.setD(readsheet.getCell(5,i).getContents());
                word.setAnswer(readsheet.getCell(6,i).getContents());

                wordlist.add(word);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return wordlist;
    }

    public static void main(String[] args) {
        List<Word> wordList=readXlsResourse("E:/words.xls");
        for(int i=0;i<wordList.size();i++){
            System.out.print(wordList.get(i).getWord());
            System.out.print("--");
            System.out.println(wordList.get(i).getAnswer());
        }
        StoragewordDAO.addWord(wordList);
    }
}
