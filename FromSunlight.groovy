
double coverage_ft2 = 10000 // roughly the sqft coverage area of makerspace
double feet_per_meter = 3.28084
double coverage_m2 = coverage_ft2 / Math.pow(feet_per_meter,2)
double solar_insolation_per_m2 = 4.5 // kilowatt-hours per square meter for an average yearly day in Massachusetts, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double solar_panel_efficiency = 0.15 // solar power aggregate 15% power efficiency, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double kilowatthours_per_day = coverage_m2 * solar_insolation_per_m2 * solar_panel_efficiency // expected kilowatt-hours for an average yearly day in Massachusetts, taking into account aggregate solar panel efficiency


def formatted_kwh = String.format("%.2f", kilowatthours_per_day)
println("kW*hr/day = $formatted_kwh")

double power_draw = 0.0				// assumed amountof power in Watts being used to run the robots et the building et al
double growing_kilowatthours_per_day = kilowatthours_per_day - power_draw		//	energy per day used for grow light LEDs

double watt_per_sqft_grow_area = 32 // see Grow Lights: How Many Watts Per Square Foot is Needed? https://trimleaf.com/blogs/articles/grow-lights-how-many-watts-per-plant-square-foot-is-needed#:~:text=Thirty%2Dtwo%20watts%20of%20power,beyond%2040%20per%20square%20foot
double LED_hrs_per_day = 16