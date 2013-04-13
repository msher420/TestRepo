package com.car;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class TestListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6860285319849115996L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("END PHASE " + event.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("START PHASE " + event.getPhaseId());

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;

	}

}
