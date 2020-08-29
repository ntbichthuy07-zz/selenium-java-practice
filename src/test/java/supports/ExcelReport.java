package supports;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by hado on 3/18/17.
 */
public class ExcelReport implements ITestListener {
    public int numberPassedTests = 0;
    public int numberFailedTests = 0;
    public int numberSkipTest = 0;
    public long durations = 0;
    public HashMap<String, HashMap<String, String>> suiteResult = new HashMap<String, HashMap<String, String>>();
//	public Map<String,String> suiteResult=new HashMap<String,String>();


    public void onTestStart(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " start");
    }


    public void onTestSuccess(ITestResult result) {
        long tcduration = result.getEndMillis() - result.getStartMillis();
        numberPassedTests++;
        durations = durations + tcduration / 60;
        HashMap<String, String> testResult = new HashMap<String, String>();
        testResult.put("TC_Name", getTestMethodName(result));
        testResult.put("Result", "Passed");
        testResult.put("Durations", String.valueOf(tcduration / 60));
        suiteResult.put(getTestMethodName(result), testResult);

    }


    public void onTestFailure(ITestResult result) {
        long tcduration = result.getEndMillis() - result.getStartMillis();
        numberFailedTests++;
        durations = durations + tcduration / 60;
        HashMap<String, String> testResult = new HashMap<String, String>();
        testResult.put("TC_Name", getTestMethodName(result));
        testResult.put("Result", "Failed");

        testResult.put("Error_Log", result.getThrowable().toString());
        testResult.put("Durations", String.valueOf(tcduration / 60));
        suiteResult.put(getTestMethodName(result), testResult);
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("test method " + getTestMethodName(result) + " skipped");
        numberSkipTest++;
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("test failed but within success % " + getTestMethodName(result));
    }


    public void onStart(ITestContext context) {
        System.out.println("on start of test " + context.getName());
    }


    public void onFinish(ITestContext context) {
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = "Report_" + context.getName() + "_" + time + ".xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Create sheet Result
        XSSFSheet sheet = workbook.createSheet("Result");

        // Create format for cell style
        XSSFCellStyle cellStyle = createCellStyle(sheet);

        // Failed test format
        XSSFCellStyle failedStyle = sheet.getWorkbook().createCellStyle();
        Font failedfont = sheet.getWorkbook().createFont();
        ((XSSFFont) failedfont).setBold(true);
        failedfont.setColor(IndexedColors.RED.getIndex());
        failedfont.setFontHeightInPoints((short) 13);
        failedStyle.setFont(failedfont);
        failedStyle.setAlignment(HorizontalAlignment.CENTER);
        failedStyle.setBorderBottom(CellStyle.BORDER_THIN);
        failedStyle.setBorderTop(CellStyle.BORDER_THIN);
        failedStyle.setBorderLeft(CellStyle.BORDER_THIN);
        failedStyle.setBorderRight(CellStyle.BORDER_THIN);


        // Passed test format
        XSSFCellStyle passedStyle = sheet.getWorkbook().createCellStyle();
        Font passedfont = sheet.getWorkbook().createFont();
        ((XSSFFont) passedfont).setBold(true);
        passedfont.setColor(IndexedColors.GREEN.getIndex());
        passedfont.setFontHeightInPoints((short) 13);
        passedStyle.setFont(passedfont);
        passedStyle.setAlignment(HorizontalAlignment.CENTER);
        passedStyle.setBorderBottom(CellStyle.BORDER_THIN);
        passedStyle.setBorderTop(CellStyle.BORDER_THIN);
        passedStyle.setBorderLeft(CellStyle.BORDER_THIN);
        passedStyle.setBorderRight(CellStyle.BORDER_THIN);


        // Normal test format
        XSSFCellStyle normalStyle = sheet.getWorkbook().createCellStyle();
        Font normalfont = sheet.getWorkbook().createFont();
        ((XSSFFont) normalfont).setBold(true);
        passedfont.setColor(IndexedColors.BLACK.getIndex());
        passedfont.setFontHeightInPoints((short) 13);
        normalStyle.setFont(passedfont);
        normalStyle.setAlignment(HorizontalAlignment.CENTER);
        normalStyle.setBorderBottom(CellStyle.BORDER_THIN);
        normalStyle.setBorderTop(CellStyle.BORDER_THIN);
        normalStyle.setBorderLeft(CellStyle.BORDER_THIN);
        normalStyle.setBorderRight(CellStyle.BORDER_THIN);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
        Row titleRow = sheet.createRow(0);
        Cell cellTitle = titleRow.createCell(0);
        cellTitle.setCellStyle(cellStyle);
        cellTitle.setCellValue("Summary report");

        Row summaryRow = sheet.createRow(4);
        Row summaryRowDetails = sheet.createRow(5);

        Cell passedCell = summaryRow.createCell(0);
        passedCell.setCellStyle(cellStyle);
        passedCell.setCellValue("PASSED");
        Cell numberPassTests = summaryRowDetails.createCell(0);
        numberPassTests.setCellStyle(normalStyle);
        numberPassTests.setCellValue(numberPassedTests);

        Cell failedCell = summaryRow.createCell(1);
        failedCell.setCellStyle(cellStyle);
        failedCell.setCellValue("FAILED");
        Cell numberFailTests = summaryRowDetails.createCell(1);
        numberFailTests.setCellStyle(normalStyle);
        numberFailTests.setCellValue(numberFailedTests);


        Cell NACell = summaryRow.createCell(2);
        NACell.setCellStyle(cellStyle);
        NACell.setCellValue("N/A");
        Cell numberSkipTests = summaryRowDetails.createCell(2);
        numberSkipTests.setCellStyle(normalStyle);
        numberSkipTests.setCellValue(numberSkipTest);

        Cell passrateCell = summaryRow.createCell(3);
        passrateCell.setCellStyle(cellStyle);
        passrateCell.setCellValue("PASS RATE");

        XSSFCellStyle passrate = sheet.getWorkbook().createCellStyle();
        passrate.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
        passrate.setBorderBottom(CellStyle.BORDER_THIN);
        passrate.setBorderTop(CellStyle.BORDER_THIN);
        passrate.setBorderLeft(CellStyle.BORDER_THIN);
        passrate.setBorderRight(CellStyle.BORDER_THIN);
        Cell passrateValue = summaryRowDetails.createCell(3);
        passrateValue.setCellStyle(passrate);
        passrateValue.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        passrateValue.setCellFormula("A6/SUM(A6:B6)");


        Cell durationsCell = summaryRow.createCell(4);
        durationsCell.setCellStyle(cellStyle);
        durationsCell.setCellValue("DURATIONS(second)");
        Cell durationsTime = summaryRowDetails.createCell(4);
        durationsTime.setCellStyle(normalStyle);
        durationsTime.setCellValue(durations);


//	        Detail results
        Row detailRow = sheet.createRow(8);


        Cell oderCell = detailRow.createCell(0);
        oderCell.setCellStyle(cellStyle);
        oderCell.setCellValue("No");

        Cell featureCell = detailRow.createCell(1);
        featureCell.setCellStyle(cellStyle);
        featureCell.setCellValue("Feature");

        Cell TCID = detailRow.createCell(2);
        TCID.setCellStyle(cellStyle);
        TCID.setCellValue("TC ID");

        Cell TCName = detailRow.createCell(3);
        TCName.setCellStyle(cellStyle);
        TCName.setCellValue("TC Name");


        Cell result = detailRow.createCell(4);
        result.setCellStyle(cellStyle);
        result.setCellValue("Result");

        Cell log = detailRow.createCell(5);
        log.setCellStyle(cellStyle);
        log.setCellValue("Error Logs");

        Cell durations = detailRow.createCell(6);
        durations.setCellStyle(cellStyle);
        durations.setCellValue("Durations");
        int noNum = 1;
        int firstRow = 9;
        for (String key : suiteResult.keySet()) {
            Row tcDetails = sheet.createRow(firstRow);
            Cell noCell = tcDetails.createCell(0);
            noCell.setCellStyle(normalStyle);
            noCell.setCellValue(noNum);

            Cell feaCell = tcDetails.createCell(1);
            feaCell.setCellStyle(normalStyle);
            feaCell.setCellValue(context.getName());

            Cell testName = tcDetails.createCell(3);
            testName.setCellStyle(normalStyle);
            testName.setCellValue(suiteResult.get(key).get("TC_Name"));

            Cell cellResult = tcDetails.createCell(4);
            cellResult.setCellStyle(normalStyle);
            Cell cellErrorLog = tcDetails.createCell(5);
            cellErrorLog.setCellStyle(normalStyle);
            if (suiteResult.get(key).get("Result") == "Failed") {
                cellResult.setCellStyle(failedStyle);
                cellResult.setCellValue(suiteResult.get(key).get("Result"));
                cellErrorLog.setCellStyle(failedStyle);
                cellErrorLog.setCellValue(suiteResult.get(key).get("Error_Log"));
            } else {
                cellResult.setCellStyle(passedStyle);
                cellResult.setCellValue(suiteResult.get(key).get("Result"));

            }

            Cell durationCell = tcDetails.createCell(6);
            durationCell.setCellStyle(normalStyle);
            durationCell.setCellValue(suiteResult.get(key).get("Durations"));
            noNum++;
            firstRow++;
        }

        try (FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/target/" + fileName)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public XSSFCellStyle createCellStyle(XSSFSheet sheet) {
        XSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        ((XSSFFont) font).setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 13);
        cellStyle.setFont(font);
        XSSFColor Header = new XSSFColor(new java.awt.Color(53, 138, 65)); // #f2dcdb
        cellStyle.setFillForegroundColor(Header);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        return cellStyle;
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();

    }
}