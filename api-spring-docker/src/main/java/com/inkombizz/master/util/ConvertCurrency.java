package com.inkombizz.master.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ConvertCurrency extends NumbLang{

	public static String toStringIDR(long val) {
		NumbLang numbLang = new NumbLang();
		StringBuilder sb = new StringBuilder();
		if (val == 0)
			return sb.append("Nol").toString();

		// cek milyaran
		if (val / numbLang.getL5() > 0) {
			sb.append(toStringIDR(val / numbLang.getL5()));
			sb.append(" ");
			sb.append("Milyar");
			sb.append(" ");
			val %= numbLang.getL5();
		}
		
		// cek jutaan
		if (val / numbLang.getL4() > 0) {
			sb.append(toStringIDR(val / numbLang.getL4()));
			sb.append(" "); 
			sb.append("Juta");
			sb.append(" ");
			val %= numbLang.getL4();
		}
		
		// cek ribuan
		if (val / numbLang.getL3() > 0) {
			if ((val / numbLang.getL3()) == 1) {
				sb.append("Seribu");
				sb.append(" ");
			} else {
				sb.append(toStringIDR(val / numbLang.getL3()));
				sb.append(" ");
				sb.append("Ribu");
				sb.append(" ");
			}
			val %= numbLang.getL3();
		}

		// cek ratusan
		if (val / numbLang.getL2() > 0) {
			if ((val / numbLang.getL2()) == 1) {
				sb.append("Seratus");
				sb.append(" ");
			} else {
				sb.append(toStringIDR(val / numbLang.getL2()));
				sb.append(" ");
				sb.append("ratus");
				sb.append(" ");
			}
			val %= numbLang.getL2();
		}

		if ((int) val > 0) {
			if ((int) val < 20) {
				sb.append(numbLang.getNb()[(int) val]);
			} else {
				sb.append(numbLang.getMt()[((int) val / (int) numbLang.getL1()) - 1]);
				long tmp = val % numbLang.getL1();
				if (tmp > 0) {
					sb.append(" ");
					sb.append(numbLang.getNb()[((int) val % (int) numbLang.getL1())]);
				}
			}
		}

		return sb.toString();
	}
	
	public static String toFormatIdr(double val){
		DecimalFormat idr = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols ftIdr = new DecimalFormatSymbols();

        ftIdr.setCurrencySymbol("Rp. ");
        ftIdr.setMonetaryDecimalSeparator(',');
        ftIdr.setGroupingSeparator('.');

        idr.setDecimalFormatSymbols(ftIdr);
        return idr.format(val);
	}
}
