package com.belajarspringboot.resto.enumated;

public enum EnumStatusPesanan {

    SEDANG_DIBUAT("Sedang dibuatin  oleh koki"),

    SELESAI("Selasai");

    private String label;

    EnumStatusPesanan(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
