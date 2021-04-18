package com.gildedrose.item_types.backstage.quality;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class QualityCalculatorProvider {

    private final List<QualityCalculator> qualityCalculators;

    public Optional<QualityCalculator> getQualityCalculator(int sellIn) {
        return qualityCalculators.stream()
                .filter(it -> it.applyTo(sellIn))
                .findFirst();
    }

}
