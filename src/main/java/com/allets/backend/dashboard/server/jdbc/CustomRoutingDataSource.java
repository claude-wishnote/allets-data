package com.allets.backend.dashboard.server.jdbc;

import com.allets.backend.dashboard.server.ApiConstants;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

		if (isReadOnly)
			return ApiConstants.DATASOURCE_TYPE_READ;
		else
			return ApiConstants.DATASOURCE_TYPE_COMMON;
	}

}
