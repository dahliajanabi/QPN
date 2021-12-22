package Enumerations;

import java.io.Serializable;

public enum PetriObjectType implements Serializable{
	Undefined,
	PetriNet,
	PetriPlace,
	PetriTransition,
	PetriData,
	DataComplexVector,
	DataArcMatrix,
	DataTransfer,
	DataDoubleDouble,
	DataBoolean,
	ComplexVector2D,
	ComplexVector2DMatrix
}
