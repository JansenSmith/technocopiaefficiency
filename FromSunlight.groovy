println()
double coverage_ft2 = 10000 // roughly the sqft coverage area of makerspace
double feet_per_meter = 3.28084
double coverage_m2 = coverage_ft2 / Math.pow(feet_per_meter,2)	// coverage area in m^2 of solar panels
double solar_insolation_per_m2 = 4.5 // kilowatt-hours per square meter for an average yearly day in Massachusetts, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double solar_panel_efficiency = 0.15 // solar power aggregate 15% power efficiency, estimated from https://www.solar-electric.com/learning-center/solar-insolation-maps.html/
double kilowatthours_per_day_generated = coverage_m2 * solar_insolation_per_m2 * solar_panel_efficiency // expected kilowatt-hours for an average yearly day in Massachusetts, taking into account aggregate solar panel efficiency

def formatted_kwh = String.format("%.2f", kilowatthours_per_day_generated)
println("kW*hr/day generated = $formatted_kwh")

double power_draw = 0.0				// assumed amountof power in Watts being used to run the robots et the building et al
double growing_kilowatthours_per_day = kilowatthours_per_day_generated - power_draw		//	kW*hr/day - energy per day used for grow light LEDs

double watts_per_sqft_grow_area = 32 // see Grow Lights: How Many Watts Per Square Foot is Needed? - https://trimleaf.com/blogs/articles/grow-lights-how-many-watts-per-plant-square-foot-is-needed#:~:text=Thirty%2Dtwo%20watts%20of%20power,beyond%2040%20per%20square%20foot
double kilowatts_per_sqft_grow_area = watts_per_sqft_grow_area/1000	//	kW/sqft
double kilowatts_per_m2_grow_area = kilowatts_per_sqft_grow_area * Math.pow(feet_per_meter,2)	// kW/m2

double LED_hrs_per_day = 16	// see Effect of Extended Photoperiod with a Fixed Mixture of Light Wavelengths on Tomato Seedlings - https://journals.ashs.org/hortsci/view/journals/hortsci/55/11/article-p1832.xml#T2

double kilowatthours_per_day_consumed_per_m2_grow_area = kilowatts_per_m2_grow_area * LED_hrs_per_day // kW*hr per square meter of grow area per day

def formatted_kilowatthours_per_day_consumed_per_m2_grow_area = String.format("%.2f", kilowatthours_per_day_consumed_per_m2_grow_area)
println("kW*hr/day consumed for each m^2 grow area = $formatted_kilowatthours_per_day_consumed_per_m2_grow_area")

double m2_grow_area = kilowatthours_per_day_generated / kilowatthours_per_day_consumed_per_m2_grow_area	// sustainable grow area in m^2

def formatted_m2_grow_area = String.format("%.2f", m2_grow_area)
println("sustainable grow area in m^2 = $formatted_m2_grow_area")

double carrot_plants_per_sqft_grow_area = 16	// plants/sqft - see How Much Can You Really Grow in a 4ft. x 4ft. Raised Bed? - https://www.gardenary.com/blog/how-much-can-you-really-grow-in-a-4ft-x-4ft-raised-bed
double carrot_plants_per_m2_grow_area = carrot_plants_per_sqft_grow_area * Math.pow(feet_per_meter,2) // plants/m^2
double carrot_grow_days = 80
double carrot_lbs_harvest_per_plant = 0.2
double carrot_lbs_per_day_per_m2_grow_area = carrot_plants_per_m2_grow_area * carrot_lbs_harvest_per_plant / carrot_grow_days // lbs/(day*m^2)

def formatted_carrot_lbs_per_day_per_m2_grow_area = String.format("%.2f", carrot_lbs_per_day_per_m2_grow_area)
println("lbs of carrot, per day, per m^2 of grow area = $formatted_carrot_lbs_per_day_per_m2_grow_area")

double carrot_lbs_per_day_output = carrot_lbs_per_day_per_m2_grow_area * m2_grow_area // lbs/day in aggregate

def formatted_carrot_lbs_per_day_output = String.format("%.2f", carrot_lbs_per_day_output)
println("aggregate nutritious output in lbs of carrot, per day = $formatted_carrot_lbs_per_day_output")

println()
println("Please note that this model currently assumes ALL power goes directly to grow light LEDs.")
println()