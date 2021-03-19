

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException; 
import java.io.InputStreamReader; 

// import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;

// import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import java.util.*;
import java.nio.charset.StandardCharsets;


public class TekstoSifravimas {
	
	public static void main(String[] args)  throws IOException  {

		File fileDir = new File( "tekstas.txt" );
		BufferedReader br = new BufferedReader(  new InputStreamReader(  new FileInputStream ( fileDir ), "UTF8" ) );
		
		BufferedReader reader = new BufferedReader ( new InputStreamReader (System.in ) );
		
		System.out.print ( "Iveskite sifravimo tvarka : " );
		String[] tvarka_strs = reader.readLine().split( "," );
		Integer[] tvarka_sk = new Integer[ 8 ];
		String[] zodziai8 = new String[ 8 ];
		
		int k = 0; 
		int suma =0;
		for ( String zodzio_nr : tvarka_strs ) {
		
			tvarka_sk [ k ] = Integer.parseInt ( zodzio_nr );
			suma += tvarka_sk [ k ];
			k++;
		}

		
		System.out.println ( "tvarkos skaiciu kontroline suma : " + suma );
		
		String thisLine;
		String[] tekstas = new String [100 ];
		String[] uzsifruotas_tekstas = new String [ 100 ];
		
		int j = 0;

		while ( ( thisLine = br.readLine() ) != null ) {
			
			tekstas [ j ] = thisLine;
			String[] zodziai = thisLine.split( " " );
			
			String tarp_zodis;
			
			for ( int i = 0; i < zodziai.length - 1; i+=2 ) {
			
				// atliekamas žodžiu sukeitimas
				
				tarp_zodis = zodziai [ i ];
				zodziai [ i ] = zodziai [ i + 1 ];
				zodziai [ i + 1 ] = tarp_zodis; 
			}
			List<String> strList = Arrays.asList ( zodziai );
			String uzsifruota_eilute = String.join ( " ", strList );
			
			System.out.println ( uzsifruota_eilute );
			uzsifruotas_tekstas [ j ] = uzsifruota_eilute;
			j++;
		}
		
		File res_file_dir = new File( "uzsifruotas_tekstas.txt" );		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter ( new FileOutputStream ( res_file_dir ) , StandardCharsets.UTF_8 ) );
		
		// for ( String eilute : uzsifruotas_tekstas ) { 
		for ( int i = 0; i < j; i++ ) {
							
			bw.write ( uzsifruotas_tekstas [ i ] + "\n");
		}
		bw.close();		
	}
}