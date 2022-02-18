package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Person;

public class Program {

	public static void main(String[] args){
		
		List<Person> persons = new ArrayList<>();
		String[] list = new String[4];
		String path = "/home/alisson/Área de Trabalho/macs/relacao-de-macs.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				list = line.split(",");
				persons.add(new Person(list[0], list[1], list[2], list[3]));
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String pathWriter = "/home/alisson/Área de Trabalho/macs/out/vencidos.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter))){
			
			for (Person line : persons) {
				if (line.defeated().equals("Vencido")) {
					bw.write(line.toString());
					bw.newLine();
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String pathWriter1 = "/home/alisson/Área de Trabalho/macs/out/nao-vencidos.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter1))){
			
			for (Person line : persons) {
				if (line.defeated().equals("OK")) {
					bw.write(line.toString());
					bw.newLine();
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
