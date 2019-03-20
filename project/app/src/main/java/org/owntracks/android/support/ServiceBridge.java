package org.owntracks.android.support;

import org.owntracks.android.injection.scopes.PerApplication;
import org.owntracks.android.services.BackgroundService;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import androidx.annotation.NonNull;

@PerApplication
public class ServiceBridge {
    private WeakReference<ServiceBridgeInterface> serviceWeakReference;

    public interface ServiceBridgeInterface {
        void requestOnDemandLocationUpdate();
    }

    @Inject
    ServiceBridge() {
    }

    public void bind(@NonNull ServiceBridgeInterface service) {
        this.serviceWeakReference = new WeakReference<ServiceBridgeInterface>(service);
    }

    public void requestOnDemandLocationFix() {
        ServiceBridgeInterface service = serviceWeakReference.get();
        if(service != null) {
            service.requestOnDemandLocationUpdate();
        }
    }


}
