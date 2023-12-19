package day5;

import java.util.ArrayList;
import java.util.HashMap;

public class MainDay5 {
	
	private static boolean isDebug = false;
	
	private static long[] initialSeeds;
	
	private static long[][] seedsStateForCategories;
	
	private static HashMap<String, ConversionMap> conversionMaps;
	
	/**
	 * Transforme les données de l'input 
	 * @throws Exception
	 */
	public static void convertInput(boolean isV1) throws Exception {
		//Générer les tables de conversion
		conversionMaps = new HashMap<String, ConversionMap>();
		
		//Convertir l'input pour les graines
		if(isDebug) {
			if(isV1) {
				initialSeeds = convertInputToSeedsV1(InputDay5_Test.INPUT_DAY5_SEEDS);
			} else {
				initialSeeds = convertInputToSeedsV2(InputDay5_Test.INPUT_DAY5_SEEDS);
			}
			
		
			//Générer les tables de conversion
			conversionMaps.put("seed-to-soil", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_SEED_TO_SOIL, Category.SEED, Category.SOIL));
			conversionMaps.put("soil-to-fertilizer", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_SOIL_TO_FERTILIZER, Category.SOIL, Category.FERTILIZER));
			conversionMaps.put("fertilizer-to-water", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_FERTILIZER_TO_WATER, Category.FERTILIZER, Category.WATER));
			conversionMaps.put("water-to-light", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_WATER_TO_LIGHT, Category.WATER, Category.LIGHT));
			conversionMaps.put("light-to-temperature", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_LIGHT_TO_TEMPERATURE, Category.LIGHT, Category.TEMPERATURE));
			conversionMaps.put("temperature-to-humidity", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_TEMPERATURE_TO_HUMIDITY, Category.TEMPERATURE, Category.HUMIDITY));
			conversionMaps.put("humidity-to-location", convertInputToConversionMap(InputDay5_Test.INPUT_DAY5_HUMIDITY_TO_LOCATION, Category.HUMIDITY, Category.LOCATION));
		} else {
			if(isV1) {
				initialSeeds = convertInputToSeedsV1(InputDay5.INPUT_DAY5_SEEDS);
			} else {
				initialSeeds = convertInputToSeedsV2(InputDay5.INPUT_DAY5_SEEDS);
			}
			
			
			//Générer les tables de conversion
			conversionMaps.put("seed-to-soil", convertInputToConversionMap(InputDay5.INPUT_DAY5_SEED_TO_SOIL, Category.SEED, Category.SOIL));
			conversionMaps.put("soil-to-fertilizer", convertInputToConversionMap(InputDay5.INPUT_DAY5_SOIL_TO_FERTILIZER, Category.SOIL, Category.FERTILIZER));
			conversionMaps.put("fertilizer-to-water", convertInputToConversionMap(InputDay5.INPUT_DAY5_FERTILIZER_TO_WATER, Category.FERTILIZER, Category.WATER));
			conversionMaps.put("water-to-light", convertInputToConversionMap(InputDay5.INPUT_DAY5_WATER_TO_LIGHT, Category.WATER, Category.LIGHT));
			conversionMaps.put("light-to-temperature", convertInputToConversionMap(InputDay5.INPUT_DAY5_LIGHT_TO_TEMPERATURE, Category.LIGHT, Category.TEMPERATURE));
			conversionMaps.put("temperature-to-humidity", convertInputToConversionMap(InputDay5.INPUT_DAY5_TEMPERATURE_TO_HUMIDITY, Category.TEMPERATURE, Category.HUMIDITY));
			conversionMaps.put("humidity-to-location", convertInputToConversionMap(InputDay5.INPUT_DAY5_HUMIDITY_TO_LOCATION, Category.HUMIDITY, Category.LOCATION));
		}
	}
	
	/**
	 * Convertir l'input pour les graines
	 * V1: chaque nombre correspond à une graine
	 * @param seedsLine : tableau des graines
	 * @return
	 */
	private static long[] convertInputToSeedsV1(String seedsLine) throws IllegalArgumentException{
		if(!seedsLine.startsWith("seeds: "))
			throw new IllegalArgumentException("convertInputSeeds(): L'input n'est pas la liste des graines - input: '" + seedsLine + "'");
		
		String[] seeds = seedsLine.substring(7).split(" ");
		
		long[] seedsTab = new long[seeds.length];
		
		for(int indexSeed = 0; indexSeed < seeds.length; indexSeed++) {
			seedsTab[indexSeed] = Long.parseLong(seeds[indexSeed]);
		}
		
		return seedsTab;
	}
	
	/**
	 * Convertir l'input pour les graines
	 * V2: chaque paire de nombres correspond à une intervalle de graines (départ, longueur)
	 * @param seedsLine : tableau des graines
	 * @return
	 */
	private static long[] convertInputToSeedsV2(String seedsLine) throws IllegalArgumentException{
		if(!seedsLine.startsWith("seeds: "))
			throw new IllegalArgumentException("convertInputSeeds(): L'input n'est pas la liste des graines - input: '" + seedsLine + "'");
		
		String[] seeds = seedsLine.substring(7).split(" ");
		
		
		ArrayList<Long> seedsList = new ArrayList<Long>();
		
		Long nbSeedsInRange;
		Long seedValue;
		for(int indexSeed = 0; indexSeed < seeds.length; indexSeed += 2) {
			//seedsTab[indexSeed] = Long.parseLong(seeds[indexSeed]);
		
			//-1 ou <= pour prendre en compte le fait que les intervalles contiennent le nombre de départ
			//nbSeedsInRange = Long.parseLong(seeds[indexSeed]) + Long.parseLong(seeds[indexSeed + 1]);
			nbSeedsInRange = Long.parseLong(seeds[indexSeed + 1]);
			for(long indexSeedInRange = 0; indexSeedInRange < nbSeedsInRange; indexSeedInRange++) {
				seedValue = Long.parseLong(seeds[indexSeed]) + indexSeedInRange;
				
				seedsList.add(seedValue);
			}
		}
		
		//Retourner la liste des graines
		long[] seedsTab = new long[seedsList.size()];
		int indexSeedTab = 0;
		
		for(long seedValueToAdd : seedsList) {		
			seedsTab[indexSeedTab] = seedValueToAdd;
			indexSeedTab++;
		}
		
		return seedsTab;
	}
	
	/**
	 * Convertir l'input d'une table de conversion en ConversionMap
	 * @param inputConversionMap
	 * @return
	 */
	private static ConversionMap convertInputToConversionMap(String inputConversionMap, Category categorySource, Category categoryDestination) {
		ConversionMap conversionMap = new ConversionMap(categorySource, categoryDestination);
			
		
		// Séparation de l'entrée en lignes
        String[] lines = inputConversionMap.split("\r\n");
        
        long[][] rangeLines = new long[lines.length][5];
        
        
        //Séparation de chaque lignes de nombre en nombre séparés
        String[] elementsNumbers; 	
        long rangeLength; //Seul nombre utilisé plusieurs fois (évite parseInt() plusieurs fois)
        
        for(int indexLine = 0; indexLine < lines.length; indexLine++) {
        	elementsNumbers = lines[indexLine].trim().split(" ");
    		
        	//Range length
    		rangeLength = Integer.parseInt(elementsNumbers[2]) - 1;
    		rangeLines[indexLine][4] = rangeLength + 1;
    		
    		//Destination range
    		rangeLines[indexLine][0] = Long.parseLong(elementsNumbers[0]);
    		rangeLines[indexLine][1] = rangeLines[indexLine][0] + rangeLength;
    		
    		//Source range
    		rangeLines[indexLine][2] = Long.parseLong(elementsNumbers[1]);
    		rangeLines[indexLine][3] = rangeLines[indexLine][2] + rangeLength;
        }
		
 
		conversionMap.setRangeLines(rangeLines);
		return conversionMap;
	}
	
	/**
	 * Convertit une graine entre les différents états 
	 * @param seedNumber
	 * @return le tableau correspondant au nombre obtenu à chaque état
	 */
	public static long[] convertSeedToLocation(long seedNumber) {
		long[] seedStates = new long[8];
		
		Category currentState = Category.SEED;
		
		//Etat seed
		seedStates[0] = seedNumber;
		
		String conversionMapName;
		
		for(int indexState = 1; indexState <= conversionMaps.size(); indexState++) {
			conversionMapName = Category.getNameConversionMapFromCategorySource(currentState);
			seedStates[indexState] = conversionMaps.get(conversionMapName).convertSourceToDestination(seedStates[indexState - 1]);
		
//			System.out.println("convertSeedToLocation: conversion " + conversionMapName + " - source=" + seedStates[indexState - 1] + " destination=" + seedStates[indexState]);
		
			currentState = Category.getCategoryDestination(currentState);
		}
		
		System.out.println("convertSeedToLocation: conversion seed-location - seed=" + seedStates[0] + " destination=" + seedStates[7]);
	
		
		return seedStates;
	}
	
	/**
	 * Convertit toutes les graines vers leur location, puis détermine le nombre le plus faible
	 */
	public static long findLowestLocationNumber() {
		seedsStateForCategories = new long[initialSeeds.length][8];
		
		long[] seedStates;
		
		long minLocation = Long.MAX_VALUE;
		
		for(int indexSeed = 0; indexSeed < initialSeeds.length; indexSeed++) {
			seedStates = convertSeedToLocation(initialSeeds[indexSeed]);
			
			//Remplissage de seedsStateForCategories pour stocker en mémoire
			for(int indexState = 0; indexState < seedStates.length; indexState++) {
				seedsStateForCategories[indexSeed][indexState] = seedStates[indexState];
			}
			
			//Déterminer la location minimale
			if(minLocation > seedStates[7])
				minLocation = seedStates[7];
		}
		
		return minLocation;
	}
	
	public static void main(String[] args) throws Exception {
		
		/*convertInput(true);
		long resultV1 = findLowestLocationNumber();
		System.out.println("Result V1 : " + resultV1);
		*/
		
		convertInput(false);
		long resultV2 = findLowestLocationNumber();
		System.out.println("Result V2 : " + resultV2);
	}
}
