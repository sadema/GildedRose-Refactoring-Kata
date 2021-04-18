package com.gildedrose;

import com.gildedrose.item_types.backstage.BackstageItem;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class QualityCalculatorProvider {

    private final List<QualityCalculator> qualityCalculators;

    public Optional<QualityCalculator> getQualityCalculator(BackstageItem backstageItem) {
        return qualityCalculators.stream()
                .filter(it -> it.applyTo(backstageItem.getSellIn()))
                .findFirst();
    }

}
