package com.example.demo.dto.gpx;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://www.topografix.com/GPX/1/1", name = "gpx")
@XmlAccessorType(XmlAccessType.FIELD)
public class Gpx {
	
	private Meta metadata;
	
	private List<Wpt> wpt;
	
	private Trk trk;

	public List<Wpt> getWpt() {
		return wpt;
	}

	public void setWpt(List<Wpt> wpt) {
		this.wpt = wpt;
	}

	public Trk getTrk() {
		return trk;
	}

	public void setTrk(Trk trk) {
		this.trk = trk;
	}

	public Meta getMetadata() {
		return metadata;
	}

	public void setMetadata(Meta metadata) {
		this.metadata = metadata;
	}
	
}
