/*
 */

package com.googlecode.objectify.test.util;

import java.util.logging.Logger;

import com.googlecode.objectify.impl.ConcreteEntityMetadata;
import com.googlecode.objectify.impl.EntityNode;
import com.googlecode.objectify.impl.Transmog;

/**
 * Some basic stuff useful to tests that exercise the Transmog.
 *
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
public class TransmogTestBase extends TestBase
{
	/** */
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(TransmogTestBase.class.getName());
	

	/** Assert child is a propertynode with exactly the content specified, no other children */
	protected void assertChildValue(EntityNode parent, String childName, Object childValue) {
		EntityNode child = parent.get(childName);
		assertNodeValue(child, childValue);
	}

	/** Assert child is a propertynode with exactly the content specified, no other children */
	protected void assertChildValue(EntityNode parent, int index, Object childValue) {
		EntityNode child = parent.get(index);
		assertNodeValue(child, childValue);
	}

	/** Assert node is a propertynode with exactly the content specified, no other children */
	protected void assertNodeValue(EntityNode node, Object value) {
		EntityNode mapNode = (EntityNode)node;
		assert mapNode.isEmpty();
		assert mapNode.hasPropertyValue();
		if (mapNode.getPropertyValue() == null)
			assert mapNode.getPropertyValue() == value;
		else
			assert mapNode.getPropertyValue().equals(value);
	}

	/** */
	protected <T> Transmog<T> getTransmog(Class<T> clazz) {
		return ((ConcreteEntityMetadata<T>)fact.getMetadata(clazz)).getTransmog();
	}
}
