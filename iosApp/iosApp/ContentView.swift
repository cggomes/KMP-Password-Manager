import SwiftUI
import Shared

struct ContentView: View {
    
    let passwordViewModel = PasswordViewModel()

    var body: some View {
        NavigationView {
            PasswordView()
                .navigationTitle("Password")
        }
        .environmentObject(passwordViewModel)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
