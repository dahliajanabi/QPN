package Enumerations;

import java.io.Serializable;

public enum TransitionOperation implements Serializable{
	Undefined,
	SendOverNetwork,
	StopPetriNet,
	MakeNull,
	UnitaryMatrix,
	UnitaryMatrixJoin2by1,
	Move,
	MoveX,
	MoveY,
	MoveOneAxis,
	NormalizationFormula,
	ComplexVectorAddition,
	UnitaryMatrix0,
	UnitaryMatrix1
}
