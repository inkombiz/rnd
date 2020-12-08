package com.inkombizz.master.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumbLang {
	private final long l = 1;
	private final long l1 = 10;
	private final long l2 = 100;
	private final long l3 = 1000;
	private final long l4 = 1000000;
	private final long l5 = 1000000000;
	private String[] nb;
	private String[] mt;

	NumbLang() {
		IDR();
	}

	private void IDR() {
		nb = new String[] { "", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan",
				"Sepuluh", "Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas", "Enam belas",
				"Tujuh belas", "Delapan belas", "Sembilan belas" };

		mt = new String[] { "Sepuluh", "Dua puluh", "Tiga puluh", "Empat puluh", "Lima puluh", "Enam puluh",
				"Tujuh puluh", "Delapan puluh", "Sembilan puluh" };
	}
}
