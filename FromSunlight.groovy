
double coverage_ft2 = 10000 // roughly the sqft coverage area of makerspace
double feet_per_meter = 3.28084
double coverage_m2 = coverage_ft2 / Math.pow(feet_per_meter,2)
double solar_insolation_per_m2 = 4.5 // kilowatt-hours per square meter for an average yearly day in Massachusetts, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double solar_panel_efficiency = 0.15 // solar power aggregate 15% power efficiency, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double kilowatthours_per_day = coverage_m2 * solar_insolation_per_m2 * solar_panel_efficiency // expected kilowatt-hours for an average yearly day in Massachusetts, taking into account aggregate solar panel efficiency

print(kilowatthours_per_day)
