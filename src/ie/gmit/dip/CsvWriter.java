package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {
	
	public static void main(String[] args) {
		String filePath = "./src/benchmarking.csv";
		
		System.out.println("Writing to benchmarking.csv file: " + filePath);
		writeToCsvFile(filePath);
		
		System.out.println("Reading from benchmarking.csv file ");
		readFromCsvFile(filePath);
	}
	
	public static void writeToCsvFile(String filePath) {
		List<Benchmarking> bmList = new ArrayList<Benchmarking>();
		
		Benchmarking bm = new Benchmarking();
		bm.setSort("Bubble Sort");
		bm.set_100("0.117");
		bm.set_250("0.287");
		bm.set_500("0.652");
		bm.set_1000("1.467");
		bm.set_1750("3.266");
		bm.set_2500("5.790");
		bm.set_5000("23.519");
		bm.set_7500("55.489");
		bm.set_10000("106.868");
		bmList.add(bm);
		
		bm = new Benchmarking();
		bm.setSort("Insertion Sort");
		bm.set_100("0.042");
		bm.set_250("0.179");
		bm.set_500("0.302");
		bm.set_1000("0.784");
		bm.set_1750("1.150");
		bm.set_2500("1.945");
		bm.set_5000("4.706");
		bm.set_7500("9.416");
		bm.set_10000("15.559");
		bmList.add(bm);
		
		bm = new Benchmarking();
		bm.setSort("Selection Sort");
		bm.set_100("0.082");
		bm.set_250("0.227");
		bm.set_500("0.493");
		bm.set_1000("1.129");
		bm.set_1750("2.141");
		bm.set_2500("3.381");
		bm.set_5000("10.211");
		bm.set_7500("22.206");
		bm.set_10000("39.805");
		bmList.add(bm);
		
		bm = new Benchmarking();
		bm.setSort("Merge Sort");
		bm.set_100("0.049");
		bm.set_250("0.086");
		bm.set_500("0.154");
		bm.set_1000("0.234");
		bm.set_1750("0.362");
		bm.set_2500("0.539");
		bm.set_5000("1.199");
		bm.set_7500("1.312");
		bm.set_10000("1.795");
		bmList.add(bm);
		
		bm = new Benchmarking();
		bm.setSort("Counting Sort");
		bm.set_100("0.012");
		bm.set_250("0.019");
		bm.set_500("0.033");
		bm.set_1000("0.046");
		bm.set_1750("0.083");
		bm.set_2500("0.128");
		bm.set_5000("0.210");
		bm.set_7500("0.236");
		bm.set_10000("0.243");
		bmList.add(bm);
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath);
			
			fw.append("Size, 100, 250, 500, 1000, 1750, 2500, 5000, 7500, 10000" + "\n");
			
			for (Benchmarking bml : bmList) {
				fw.append(bml.getSort());
				fw.append(",");
				fw.append(bml.get_100());
				fw.append(",");
				fw.append(bml.get_250());
				fw.append(",");
				fw.append(bml.get_500());
				fw.append(",");
				fw.append(bml.get_1000());
				fw.append(",");
				fw.append(bml.get_1750());
				fw.append(",");
				fw.append(bml.get_2500());
				fw.append(",");
				fw.append(bml.get_5000());
				fw.append(",");
				fw.append(bml.get_7500());
				fw.append(",");
				fw.append(bml.get_10000());
				fw.append("\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readFromCsvFile(String filePath) {
		BufferedReader br = null;
		
		try {
			List<Benchmarking> bml = new ArrayList<Benchmarking>();
			String line = "";
			br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				
				if(fields.length > 0) {
					Benchmarking bm = new Benchmarking();
					bm.setSort(fields[0]);
					bm.set_100(fields[1]);
					bm.set_250(fields[2]);
					bm.set_500(fields[3]);
					bm.set_1000(fields[4]);
					bm.set_1750(fields[5]);
					bm.set_2500(fields[6]);
					bm.set_5000(fields[7]);
					bm.set_7500(fields[8]);
					bm.set_10000(fields[9]);
					bml.add(bm);
				}
			}
			
			System.out.printf("%-14s %-9s %-9s %-9s %-9s %-9s %-9s %-9s %-9s %-9s", "Size", "100", "250", "500", "1000",
					"1750", "2500", "5000", "7500", "10000");
			System.out.println();
			
			for(Benchmarking bm : bml) {
				System.out.printf("%-14s %-9s %-9s %-9s %-9s %-9s %-9s %-9s %-9s %-9s", bm.getSort(), bm.get_100(),
						bm.get_250(), bm.get_500(), bm.get_1000(), bm.get_1750(), bm.get_2500(), bm.get_5000(), 
						bm.get_7500(), bm.get_10000());
						System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
