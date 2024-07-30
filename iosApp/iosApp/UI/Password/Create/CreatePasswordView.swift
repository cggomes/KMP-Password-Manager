//
//  CreatePasswordView.swift
//  iosApp
//
//  Created by Christian Gomes on 30/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct CreatePasswordView: View {
    
    @Environment(\.dismiss) private var dismiss
    @EnvironmentObject var passwordViewModel: PasswordViewModel
    @State var appName: String = ""

    var body: some View {
        VStack {
            Form {
                Section {
                    TextField("App", text: $passwordViewModel.title)
                    TextField("Username", text: $passwordViewModel.username)
                    TextField("Password", text: $passwordViewModel.password)
                    TextField("URL (https://github.com)", text: $passwordViewModel.url)
                    TextField("App Logo", text: $passwordViewModel.appLogo)
                }
                
                Section {
                    Button("Save") {
                        passwordViewModel.savePassword()
                        dismiss()
                    }
                }
            }
        }
        .navigationTitle("Add Password")
        .navigationBarTitleDisplayMode(.inline)
    }
}

#Preview {
    CreatePasswordView()
        .environmentObject(PasswordViewModel())
}
