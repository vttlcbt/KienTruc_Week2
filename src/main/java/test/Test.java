package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Test {
	public static void main(String[] args) throws Exception {
//		getFAMs("D:\\KTPM16A\\KIEN_TRUC_PHAN_MEM\\ThucHanh\\Week2\\Tuan02\\src\\main\\java\\models\\Class.java");
		getFiles("D:\\KTPM16A\\KIEN_TRUC_PHAN_MEM\\NopBai\\Week2\\src\\main\\java\\models");
	}
	
	public static void getFiles(String folderName) throws Exception {
		File folder = new File(folderName);
		File [] files = folder.listFiles();
		for (File file : files) {
			String path = file.getAbsolutePath();
			System.out.println("-----------File path----------");
			System.out.println(path);
			System.out.println("---------------------");
			getFAMs(path);
		}
	}
	
	public static void getFAMs(String path) throws Exception{
		ParseResult<CompilationUnit> parseResult = null;
		FileInputStream input = new FileInputStream(path);
		try {
			JavaParser javaParser = new JavaParser();
			parseResult = javaParser.parse(input);
			
			Optional<CompilationUnit> optional = parseResult.getResult();
			if (optional.isPresent()) {
				CompilationUnit compilationUnit = optional.get();
				getFields(compilationUnit);
				System.out.println("---------------------");
				getMethods(compilationUnit);
				System.out.println("=====================");
			}
		} finally {
			input.close();
		}
	}
	
	public static void getFields(CompilationUnit cUnit) {
		List<FieldDeclaration> fields = cUnit.findAll(FieldDeclaration.class);
		for (FieldDeclaration field : fields) {
			System.out.println(field);
		}
	}
	
	public static void getMethods(CompilationUnit cUnit) {
		List<MethodDeclaration> methods = cUnit.findAll(MethodDeclaration.class);
		for (MethodDeclaration method : methods) {
			System.out.println(method.getName());
		}
	}
}
