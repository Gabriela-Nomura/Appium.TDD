package br.com.rsinet.hub.ProjetoAppium.Utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MassaDeDados {
	/**
	 * Classe para fixacao de atributos constantes. Leitura de dados de excel
	 */
	
	public static final String Path_TestData = "C://Users//gabriela.nomura//Documents//automacao//testData.xlsx";
	public static final int Col_NomeBusca = 0;
	public static final int Col_Elemento = 1;
	public static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

//Metodo para configurar o arquivo do excel a ser lido
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			//Abre o arquivo do excel
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Acessa a uma determinada planilha com referencia de nome do arquivo e da planilha
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

//Obtem a informa�ao da celula da coluna, recebe como par�metros os valores de linha e coluna

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

//Metodos para leitura e obtencao dos valores a partir do excel
	public static final String userName(int i) throws Exception {
		return getCellData(i, 0);
	}

	public static final String userEmail() throws Exception {
		return getCellData(1, 1);
	}

	public static final String userSenha() throws Exception {
		return getCellData(1, 2);
	}

	public static final String userSenhaConfirmacao() throws Exception {
		return getCellData(1, 3);
	}

	public static final String userPrimeiroNome() throws Exception {
		return getCellData(1, 4);
	}

	public static final String userUltimoNome() throws Exception {
		return getCellData(1, 5);
	}

	public static final String userTelefone() throws Exception {
		return getCellData(1, 6).toString();
	}

	public static final String userCidade() throws Exception {
		return getCellData(1, 7);
	}

	public static final String userEndereco() throws Exception {
		return getCellData(1, 8);
	}

	public static final String userEstado() throws Exception {
		return getCellData(1, 9);
	}

	public static final String userCep() throws Exception {
		return getCellData(1, 10).toString();
	}

	public static final String buscaLupa() throws Exception {
		return getCellData(11, 0);
	}

	public static final String buscaLupaFalha() throws Exception {
		return getCellData(12, 0);
	}
}
