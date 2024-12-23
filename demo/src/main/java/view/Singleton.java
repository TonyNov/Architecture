package view;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import view.api.CreatorAPI;
import view.api.ReaderAPI;

public class Singleton extends Application {
   private final Set<Object> singletons = new HashSet<>();
   public Singleton() {
      singletons.add(new ReaderAPI());
      singletons.add(new CreatorAPI());
   }

   @Override
   public Set<Object> getSingletons() {
      return singletons;
   }
}
