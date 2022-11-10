package CSE260;

public class PopulationData {
	public static int sum_populations(String continent, int minGDP, Map countries, Map GDPs, Map populations) {
        List<String> Continentcountries = (List<String>)countries.get(continent);
        int population_total = 0;
        for(int i = 0; i < Continentcountries.size(); i++)
        {
            String current_country = Continentcountries.get(i);

            if((int)GDPs.get(current_country) > minGDP)
            {
                population_total += (int)populations.get(current_country);
            }
        }
        return population_total;

    }

}
