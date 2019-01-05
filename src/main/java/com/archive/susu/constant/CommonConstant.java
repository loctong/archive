package com.archive.susu.constant;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MinhNQ19
 *
 */
public interface CommonConstant {

	int CONSTRUCTION_CONFIRMATION_SCHEDULED_DATE = 20;
	int CONSTRUCTION_APPLICATION_DATE = 20;
	int SPECIFICATION_CONFIRMATION_DATE = 11;
	int LIMIT_NOT_PAGING = 1;

	String ARROW_LEFT_TO_RIGHT = "⇒";

	/** Symbol separator sorting param string **/
	String SORTING_SEPARATOR = ",";

	/** Symbol sorting desc **/
	String SORTING_DESC_MARK = "-";

	String PATH_ID = "id";
	String PATH_SIZE = "size";
	String PATH_PAGE = "page";
	String PATH_FILTER_DELETED = "filterDeleted";
	String PROPERTY_TYPE = "propertyType";
	String PROCESS_SHEET_ID = "processSheetID";
	String TRADER_ID = "traderID";
	String KIND_ID = "kindID";
	String TRADER_CONTACT_ID = "contactID";
	String PATH_VALUE = "value";

	String PROCESSID = "processID";

	String CHARSET_UTF8 = "UTF-8";
	String CHARSET_SJIS = "Shift_JIS";
	String CHARSET_WINDOWS31J = "windows-31j";
	String CHARSET_MS932 = "MS932";

	String FILE_EXTENSION_EXCEL_XLSX = ".xlsx";
	
	//CSV Dynamic Header
	String KIND_HEADER = "工種";
	String TRADER_CONTACT_NAME = "担当者";
	String TRADER_CONTACT_MAIL = "メールアドレス";
	
	int MIN_PROFIT_DECREASE_RATE = 2;
	
	//20万円 
	int MIN_PROFIT_DECREASE = 200000;

	int BATCH_SIZE_FLUSH = 1000;

	int WAIT_ASYNC_DONE_IN_MS = 100; // mili-seconds

	String MAX_YEAR_VALUE = "999";

	// Constant for zip file
    int BUFFER_SIZE = 4096;
	String CONSUME_ZIP = "application/zip";
	String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	String FOLDER_SEPARATOR = "/";

	String PATH_SEPARATOR = "/";

	String DATE_FORMAT_PATTERN = "yyyy/MM/dd";
	String DATE_FORMAT_JA_PATTERN = "MM月dd日";
	String CSV_EXPORT_DATE_FORMAT_PATTERN = "yyyy/MM/dd";
	String CSV_EXPORT_YEN_CURRENCY_FORMAT_PATTERN = "¥###,###,###";

	String DATE_FORMAT_CONSTRUCTION = "yyyyMMdd";

	// CSV reader delimiter
    int CSV_DELIMITER_COMMA = 1;
	int CSV_DELIMITER_TAB = 2;
	int END_MONTH_OF_YEAR = 9;
	int START_MONTH_OF_YEAR = 10;

	double TAX = 0.08;
	
	double COOPERATION_COST_DISCOUNT = 0.01;
	
	String PATTERN_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	String PATTERN_ZIPCODE = "^\\d{3}-?\\d{2}(\\d{2})?$";
	String PATTERN_NUMBER = "^(\\d+)(\\.\\d+){0,1}$";
	String IMPORT_EXCEL_DATE_FORMAT = "yyyy/MM/dd";
    
    String PROCESS_NAME_PLANS          = "（予定）";
    String PROCESS_NAME_ACTUAL         = "（実績）";
    String PROCESS_SCHEDULED_CHANGE_NOTIFY_TITLE = "%s予定日変更";
	String PROCESS_ACTUAL_CHANGE_NOTIFY_TITLE          = "%s実績日変更";
    int PROCESS_ACTUAL_DATE_PASS_RANGE      = 180;
    int PROCESS_ACTUAL_DATE_FURTURE_RANGE      = 5;
    String MIME_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    String EXCEL_TEMPLATE_FOLDER = "templates/excel/";
    
    enum ImportMode {
		REGISTER, UPDATE
    }

	interface DB {
		interface ConstructionContract {
			int CORPORATE = 1;
			int INDIVIDUAL = 2;
		}
	}

	@SuppressWarnings("unused")
    class Validation {
		public static final String Date = "Date";
		public static final String Dependent = "Dependent";
		public static final String Exist = "Exist";
		public static final String NotBlank = "NotBlank";
		public static final String NotBlankWithCondition = "NotBlankWithCondition";
		public static final String Number = "Number";
		public static final String Digits = "Digits";
		public static final String YesNo = "YesNo";
		public static final String Zipcode = "Zipcode";
		public static final String Email = "Email";
		public static final Map<String, String> MessageCodeMap = new HashMap<>();
		static {
			Field[] fields = Validation.class.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				MessageCodeMap.put(fieldName, "Validation.Import." + fieldName);
			}
		}
	}

	interface MimeType {
		String EXCEL = "application/vnd.ms-excel";
	}

	enum DeliveryTime {
		TIME_ONE(1, "納材予定表の共有（工事現場名: "), TIME_TWO(2, "納材予定表の再共有（工事現場名: "), TIME_THREE(3, "納材予定表の再共有（工事現場名: ")

		;
		@Getter
		int value;
		@Getter
		String description;

		DeliveryTime(int value, String description) {
			this.value = value;
			this.description = description;
		}
	}

	enum Subject {
		DELIVERY_TIME_ONE(1, "納材予定表の共有（工事現場名：%s）"),
		DELIVERY_TIME_TWO(2, "納材予定表の再共有（工事現場名：%s）"),
		DELIVERY_TIME_THREE(3, "納材予定表の再共有（工事現場名：%s）"),
		LIFELINE_REMIND( 4, "ライフライン作業のお願い"),
		COMPLETION_OHA(5, "【KIZUNA-X】完工報告（工事番号:)"),
		COMPLETION_OHD(6, "【KIZUNA-X】完工報告（工事番号:)"),
		PROCESS_BATCH_MOVE(7, "【KIZUNA-X】予定工程の後方一括移動（工事No:"),
		SHEET_TYPE_MAIL(8, "床下天井点検口依頼");
		@Getter
		Integer value;
		@Getter
		String description;

		Subject(Integer value, String description) {
			this.value = value;
			this.description = description;
		}

	}

    int maxUploadSizeInMb = 10 * 1024 * 1024;
    int maxUploadSizeInMbScreen13 = 25 * 1024 * 1024;

    String[] allowContentTypes = {
            "image/png","image/jpeg","image/jpeg","image/gif","application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "application/pdf", "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
    };
    
    String TRADER_DECISION_FOLDER = "1wwniX25_pCxY034xn-7-6JjjsswEAGRT";
    
    enum OrderStatus{
        ONE(1,"ドラフト"),
        TWO(2,"発注承認依頼");
        @Getter
        Integer value;
        @Getter
        String description;
        OrderStatus(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

    }
    
    enum ClaimStatus{
        ONE(1,"発注済・未請求"),
        TWO(2,"査定依頼、"),
        THREE(3,"査定完了"),
        FOUR(4,"差し戻し"),
        FIVE(5,"支払承認"),
        SIX(6,"会計システム連携済み");
        @Getter
        Integer value;
        @Getter
        String description;
        ClaimStatus(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

    }

    enum BrandName {
        OHD_PROMOTION_DEP(71,"OHD推進部"),
        SAITAMA(73,"埼玉"),
        KANAGAWA(74,"神奈川");
        @Getter
        Integer id;
        @Getter
        String name;

        BrandName(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

	static enum MIME {
		APPLICATION_OCTET_STREAM("", "application/octet-stream"),
		APPLICATION_MS_DOCM("docm", "application/vnd.ms-word.document.macroEnabled.12"),
		APPLICATION_MS_DOTM("dotm", "application/vnd.ms-word.template.macroEnabled.12"),
		APPLICATION_MS_XLSM("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12"),
		APPLICATION_MS_XLTM("xltm", "application/vnd.ms-excel.template.macroEnabled.12"),
		APPLICATION_MS_XLSB("xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12"),
		APPLICATION_MS_XLAM("xlam", "application/vnd.ms-excel.addin.macroEnabled.12"),
		APPLICATION_MS_PPTX("pptx", "application/vnd.mspowerpoint"),
		APPLICATION_MS_PPTM("pptm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12"),
		APPLICATION_MS_PPSM("ppsm", "application/vnd.ms-powerpoint.slideshow.macroEnabled.12"),
		APPLICATION_MS_POTM("potm", "application/vnd.ms-powerpoint.template.macroEnabled.12"),
		APPLICATION_MS_PPAM("ppam", "application/vnd.ms-powerpoint.addin.macroEnabled.12"),
		APPLICATION_MS_SLDM("sldm", "application/vnd.ms-powerpoint.slide.macroEnabled.12"),
		APPLICATION_MS_ONE("one", "application/msonenote"),
		APPLICATION_MS_ONETOC2("onetoc2", "application/msonenote"),
		APPLICATION_MS_ONETMP("onetmp", "application/msonenote"),
		APPLICATION_MS_ONEPKG("onepkg", "application/msonenote"),
		APPLICATION_MS_THMX("thmx", "application/vnd.ms-officetheme"),
		APPLICATION_DOCX("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
		APPLICATION_DOTX("dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template"),
		APPLICATION_XLSX("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
		APPLICATION_XLTX("xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template"),
		APPLICATION_PPTX("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"),
		APPLICATION_PPSX("ppsx", "application/vnd.openxmlformats-officedocument.presentationml.slideshow"),
		APPLICATION_POTX("potx", "application/vnd.openxmlformats-officedocument.presentationml.template"),
		APPLICATION_SLDX("sldx", "application/vnd.openxmlformats-officedocument.presentationml.slide"),
		APPLICATION_PKCS12("pkcs12", "application/pkcs12"),
		APPLICATION_XHTML_XML("", "application/xhtml+xml"),
		APPLICATION_XML("xml", "application/xml"),
		APPLICATION_PDF("pdf", "application/pdf"),
		TEXT_PLAIN("txt", "text/plain"),
		TEXT_CSV("txt", "text/csv"),
		TEXT_HTML("html", "text/html"),
		TEXT_CSS("css", "text/css"),
		TEXT_JAVASCRIPT("js", "text/javascript"),
		IMAGE_GIF("gif", "image/gif"),
		IMAGE_PNG("png", "image/png"),
		IMAGE_JPEG("jpeg", "image/jpeg"),
		IMAGE_BMP("bmp", "image/bmp"),
		IMAGE_WEBP("webp", "image/webp"),
		AUDIO_MIDI("midi", "audio/midi"),
		AUDIO_MPEG("mpeg", "audio/mpeg"),
		AUDIO_WEBM("webm", "audio/webm"),
		AUDIO_OGG("ogg", "audio/ogg"),
		AUDIO_WAV("wav", "audio/wav"),
		VIDEO_WEBM("webm", "video/webm"),
		VIDEO_OGG("ogg", "video/ogg"),
		;

		private String extension;

		private String value;

		MIME(String extension, String value) {
			this.extension = extension;
			this.value = value;
		}

		public String extension() {
			return extension;
		}

		public String value() {
			return value;
		}

	}
	
	public enum REPORT_FORM{
	    MONTHLY_SHEET(1,"月次シート"),
	    CONTRACT_MANAGEMENT(2,"契約管理"),
	    CONTRACT_MANAGEMENT_LEDGER(3, "契約管理台帳"),
	    ATTACHMENT_STATUS_LIST(4, "資料添付状況一覧"),
	    PROGRESS_MANAGEMENT_DATA(5, "進捗管理データ"),
	    SALES_SCHEDULE(6, "売上（引渡）予定表"),
	    SCHEDULE_OF_DEPOSIT(7, "入金予定表"),
	    PAYMENT_MANAGEMENT_LIST(8, "入金管理リスト");
	    
	    @Getter
        Integer id;
        @Getter
        String name;
        private static Map<Integer, REPORT_FORM> map = new HashMap<>();

        REPORT_FORM(Integer id) {
            this.id = id;
        }
        
        REPORT_FORM(Integer id, String name) {
            this.id = id;
            this.name= name;
        }
        static {
            for (REPORT_FORM reportForm : REPORT_FORM.values()) {
                map.put(reportForm.id, reportForm);
            }
        }
        public static REPORT_FORM valueOf(int reportForm) {
            return (REPORT_FORM) map.get(reportForm);
        }
	}
	
	/**
	 * 
	 * @author DuongN
	 * @date Sep 14, 2018
	 * @doc condition to check date b084r007 
	 */
	enum DateModeCodition{
		SCHEDULE(1,"予定"),
		ACTUAL(2,"実績"),
		ALL(3,"全て");
        @Getter
        Integer value;
        @Getter
        String name;
        DateModeCodition(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

    }
	
	enum OTHER_REPORT {
        DANDORY("dandory","DANDORY!"),
        SETTLEMENT_APPROVAL("settlement-approval","決済承認申請リスト"),
        SFA("sfa","SFA案件データ"),
        CARPENTER_PAYMENT("carpenter-payment","大工支払予定表"),
        ORDER_SUMMARY("order-summary","発注集計表"),
        DISTRIBUTION_MAP("distribution-map","着工日分布図")

        ;
        @Getter
        String value;
        @Getter
        String name;

        private static Map<String, OTHER_REPORT> map = new HashMap<>();
        
        OTHER_REPORT(String value) {
        	this.value = value;
        }
        
        OTHER_REPORT(String value, String name) {
            this.value = value;
            this.name = name;
        }
        static {
            for (OTHER_REPORT template : OTHER_REPORT.values()) {
                map.put(template.value, template);
            }
        }
        public static OTHER_REPORT getValue(String template) {
            return (OTHER_REPORT) map.get(template);
        }
    }
	
	public enum ScaleTsuboType {
		/**
		 * 大規模
		 */
		LARGE(30),
		/**
		 * 小規模
		 */
		SMALL(24);
		@Getter
		int value;
		ScaleTsuboType(int value) {
			this.value = value;
		}
	}
}
