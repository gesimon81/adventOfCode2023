package day10_Pathfinding;


public enum PipeType {
	VERTICAL_PIPE, HORIZONTAL_PIPE, BEND90_NE, BEND90_NW, BEND90_SW, BEND90_SE, GROUND;   
	
	 public static PipeType getPipeTypeByString(String pipeTypeStr) throws IllegalArgumentException {
    	PipeType pipeType;
    	
    	switch(pipeTypeStr) {
    		case "|":
    			pipeType = VERTICAL_PIPE;
    			break;
    		case "-":
    			pipeType = HORIZONTAL_PIPE;
    			break;
    		case "L":
    			pipeType = BEND90_NE;
    			break;
    		case "J":
    			pipeType = BEND90_NW;
    			break;
    		case "7":
    			pipeType = BEND90_SW;
    			break;
    		case "F":
    			pipeType = BEND90_SE;
    			break;
    		case ".":
    			pipeType = GROUND;
    			break;
    		default:
    			throw new IllegalArgumentException("La valeur saisie ne correspond pas au type d'une pipe");
    	}

    	return pipeType;
	 }
	 
	 public static String getStringByPipeType(PipeType typeToConvert) {
		String pipeType;
		
		switch(typeToConvert) {
	 		case VERTICAL_PIPE:
	 			pipeType = "|";
	 			break;
	 		case HORIZONTAL_PIPE:
	 			pipeType = "-";
	 			break;
	 		case BEND90_NE:
	 			pipeType = "L";
	 			break;
	 		case BEND90_NW:
	 			pipeType = "J";
	 			break;
	 		case BEND90_SW:
	 			pipeType = "7";
	 			break;
	 		case BEND90_SE:
	 			pipeType = "F";
	 			break;
	 		case GROUND:
	 			pipeType = ".";
	 			break;
	 		default:
	 			throw new IllegalArgumentException("La valeur saisie ne correspond pas au type d'une pipe");
		}
		
		return pipeType;
	}
}
