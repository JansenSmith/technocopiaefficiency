
double coverage_ft2 = 10000 // roughly the sqft coverage area of makerspace
double feet_per_meter = 3.28084
double coverage_m2 = coverage_ft2 / Math.pow(feet_per_meter,2)	// coverage area in m^2 of solar panels
double solar_insolation_per_m2 = 4.5 // kilowatt-hours per square meter for an average yearly day in Massachusetts, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double solar_panel_efficiency = 0.15 // solar power aggregate 15% power efficiency, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double kilowatthours_per_day_generation = coverage_m2 * solar_insolation_per_m2 * solar_panel_efficiency // expected kilowatt-hours for an average yearly day in Massachusetts, taking into account aggregate solar panel efficiency

def formatted_kwh = String.format("%.2f", kilowatthours_per_day_generation)
println("kW*hr/day generation = $formatted_kwh")

double power_draw = 0.0				// assumed amountof power in Watts being used to run the robots et the building et al
double growing_kilowatthours_per_day = kilowatthours_per_day_generation - power_draw		//	kW*hr/day - energy per day used for grow light LEDs

double watts_per_sqft_grow_area = 32 // see Grow Lights: How Many Watts Per Square Foot is Needed? - https://trimleaf.com/blogs/articles/grow-lights-how-many-watts-per-plant-square-foot-is-needed#:~:text=Thirty%2Dtwo%20watts%20of%20power,beyond%2040%20per%20square%20foot
double kilowatts_per_sqft_grow_area = watts_per_sqft_grow_area/1000	//	kW/sqft
double kilowatts_per_m2_grow_area = kilowatts_per_sqft_grow_area * Math.pow(feet_per_meter,2)	//	kW/m2

double LED_hrs_per_day = 16	// see Effect of Extended Photoperiod with a Fixed Mixture of Light Wavelengths on Tomato Seedlings - https://journals.ashs.org/hortsci/view/journals/hortsci/55/11/article-p1832.xml#T2

double kilowatthours_per_day_consumed_per_m2_grow_area = kilowatts_per_m2_grow_area * LED_hrs_per_day // kW*hr per square meter of grow area per day

def formatted_kilowatthours_per_day_consumed_per_m2_grow_area = String.format("%.2f", kilowatthours_per_day_consumed_per_m2_grow_area)
println("kW*hr/day consumed for each m^2 grow area = $formatted_kilowatthours_per_day_consumed_per_m2_grow_area")

//double m2_grow_area = 