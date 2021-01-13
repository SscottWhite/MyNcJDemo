package com.example.base;

public enum MyEnumDemo {
		RED("红",1),
		WRITE("白",2),
		BLACK("黑",3),
		YELLOW("黄",4);

		private String str;
		private Integer index;
		
		MyEnumDemo(String str, int index) {
			this.str = str;
			this.index = index;			
		}

		public String getStr() {
			return str;
		}

		public Integer getIndex() {
			return index;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return this.str+"_"+this.index;
		}
		
		private static String getName(int index) {
			//循环数组
			 for(MyEnumDemo enumDemo: MyEnumDemo.values()) {
				 if(enumDemo.getIndex() == index) {
					  return enumDemo.str;
				 }
			 }
			 return null;
		}
}
