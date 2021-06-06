package Enumerations;

import java.io.Serializable;

public enum TransitionOperation implements Serializable{
	Undefined,
	SendOverNetwork,
	SendPetriNetOverNetwork,
	ActivateSubPetri,
	StopPetriNet,
	MakeNull,
	UnitaryMatrix
}
